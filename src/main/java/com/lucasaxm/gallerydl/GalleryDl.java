package com.lucasaxm.gallerydl;

import com.lucasaxm.gallerydl.exception.GalleryDlException;
import com.lucasaxm.gallerydl.exception.GalleryDlNotFoundException;
import com.lucasaxm.gallerydl.options.GalleryDlOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class GalleryDl {

    @Value("${gallery-dl.path}")
    private String galleryDlPath;

    public List<String> download(String url, GalleryDlOptions options) {
        List<String> command = options.toCommandList();
        command.add(0, galleryDlPath); // Assuming galleryDlPath is the path to the gallery-dl executable
        command.add(url);

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();

            // Reading the output from the command
            List<String> output = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.add(line);
                }
            }

            boolean terminated = process.waitFor(1, TimeUnit.MINUTES);

            if (!terminated) {
                process.destroy();
                throw new GalleryDlException("gallery-dl did not complete within the time limit", null);
            }

            int exitCode = process.exitValue();
            if (exitCode != 0) {
                throw new GalleryDlException("gallery-dl terminated with a non-zero exit code: " + exitCode, null);
            }

            return output;
        } catch (IOException e) {
            throw new GalleryDlNotFoundException("gallery-dl command not found or not executable: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new GalleryDlException("Thread was interrupted while running gallery-dl", e);
        }
    }
}
