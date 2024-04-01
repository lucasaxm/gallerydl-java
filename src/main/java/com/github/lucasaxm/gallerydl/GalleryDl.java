package com.github.lucasaxm.gallerydl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lucasaxm.gallerydl.exception.GalleryDlException;
import com.github.lucasaxm.gallerydl.exception.GalleryDlNotFoundException;
import com.github.lucasaxm.gallerydl.metadata.Metadata;
import com.github.lucasaxm.gallerydl.metadata.MetadataWrapper;
import com.github.lucasaxm.gallerydl.options.GalleryDlOptions;
import com.github.lucasaxm.gallerydl.options.GalleryDlResult;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GalleryDl {

    private String galleryDlPath;

    private ObjectMapper metadataMapper;

    public GalleryDlResult download(String url, GalleryDlOptions options) {
        options.setWriteMetadata(true);
        List<String> command = options.toCommandList();
        command.add(0, galleryDlPath); // Prepend gallery-dl command to the list
        command.add(url);

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process;

        GalleryDlResult galleryDlResult = new GalleryDlResult();
        galleryDlResult.setUrl(url);

        try {
            process = processBuilder.start();
        } catch (IOException e) {
            throw new GalleryDlNotFoundException("gallery-dl not found or not executable.", e);
        }

        try (BufferedReader outputReader = new BufferedReader(
            new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
             BufferedReader errorReader = new BufferedReader(
                 new InputStreamReader(process.getErrorStream(), StandardCharsets.UTF_8))) {

            // Read stdout
            galleryDlResult.setStdout(outputReader.lines().toList());

            // Read stderr
            galleryDlResult.setStderr(errorReader.lines().toList());

        } catch (IOException e) {
            throw new GalleryDlException("Error reading the output of gallery-dl", e);
        }

        // Wait for the process to complete
        boolean terminated;
        try {
            terminated = process.waitFor(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new GalleryDlException("Thread was interrupted while waiting for gallery-dl to terminate", e);
        }

        if (!terminated) {
            process.destroy();
            throw new GalleryDlException("gallery-dl did not complete within the time limit");
        }

        galleryDlResult.setExitCode(process.exitValue());
        if (galleryDlResult.getExitCode() != 0) {
            throw new GalleryDlException(
                String.format("gallery-dl terminated with a non-zero exit code: %d", galleryDlResult.getExitCode()),
                galleryDlResult, null);
        }

        fillMetadata(galleryDlResult, true);

        return galleryDlResult;
    }

    private void fillMetadata(GalleryDlResult galleryDlResult, boolean downloaded) {
        List<Metadata> metadataList = new ArrayList<>();
        galleryDlResult.getStdout().forEach(line -> {
            String filepathString = line.startsWith("#") ? line.substring(1).trim() : line.trim();
            Path filePath = Path.of(filepathString);
            if (downloaded && !Files.exists(filePath)) {
                throw new GalleryDlException(
                    String.format("Couldn't extract metadata, %s doesn't exist", filepathString), galleryDlResult);
            }
            Path metadataFilePath = filePath.resolveSibling(filePath.getFileName().toString() + ".json");
            if (Files.notExists(metadataFilePath)) {
                throw new GalleryDlException(
                    String.format("Couldn't extract metadata, %s doesn't exist", metadataFilePath), galleryDlResult);
            }

            Metadata metadata;
            MetadataWrapper wrapper;
            try {
                String jsonData = Files.readString(metadataFilePath);
                wrapper = metadataMapper.readValue(jsonData, MetadataWrapper.class);
                metadata = wrapper.convertToSpecificMetadata();
                if (downloaded) {
                    metadata.setLocalPath(filepathString);
                }
            } catch (IOException e) {
                throw new GalleryDlException(String.format("Error reading metadata file: %s", metadataFilePath),
                    galleryDlResult, e);
            }
            metadataList.add(metadata);
        });
        galleryDlResult.setMetadata(metadataList);
    }
}
