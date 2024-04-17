package com.github.lucasaxm.gallerydl.options;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class GalleryDlOptions {
    // General Options
    private String filenameFormat;
    private String destination;
    private String directory;
    private String extractors;
    private String proxy;
    private String sourceAddress;
    private String userAgent;
    private String clearCache;

    // Input Options
    private String inputFile;
    private String inputFileComment;
    private String inputFileDelete;

    // Output Options
    private Boolean quiet;
    private Boolean verbose;
    private Boolean getUrls;
    private Boolean resolveUrls;
    private Boolean dumpJson;
    private Boolean simulate;
    private Boolean extractorInfo;
    private Boolean listKeywords;
    private String errorFile;
    private Boolean listModules;
    private Boolean listExtractors;
    private String writeLog;
    private String writeUnsupported;
    private Boolean writePages;

    // Downloader Options
    private String limitRate;
    private Integer retries;
    private Double httpTimeout;
    private String sleep;
    private Double sleepRequest;
    private Double sleepExtractor;
    private String filesizeMin;
    private String filesizeMax;
    private String chunkSize;
    private Boolean noPart;
    private Boolean noSkip;
    private Boolean noMtime;
    private Boolean noDownload;
    private Boolean noPostprocessors;
    private Boolean noCheckCertificate;

    // Configuration Options
    private String option;
    private String config;
    private String configYaml;
    private String configToml;
    private Boolean configCreate;
    private Boolean configIgnore;

    // Authentication Options
    private String username;
    private String password;
    private Boolean netrc;

    // Cookie Options
    private String cookies;
    private String cookiesExport;
    private String cookiesFromBrowser;

    // Selection Options
    private String downloadArchive;
    private Integer abort;
    private Integer terminate;
    private String range;
    private String chapterRange;
    private String filter;
    private String chapterFilter;

    // Post-processing Options
    private String postprocessor;
    private String postprocessorOption;
    private Boolean writeMetadata;
    private Boolean writeInfoJson;
    private Boolean writeTags;
    private Boolean zip;
    private Boolean cbz;
    private String mtime;
    private String ugoira;
    private String exec;
    private String execAfter;

    public List<String> toCommandList() {
        List<String> commandList = new ArrayList<>();
        addNonNull(commandList, "--filename", filenameFormat);
        addNonNull(commandList, "--destination", destination);
        addNonNull(commandList, "--directory", directory);
        addNonNull(commandList, "--extractors", extractors);
        addNonNull(commandList, "--proxy", proxy);
        addNonNull(commandList, "--source-address", sourceAddress);
        addNonNull(commandList, "--user-agent", userAgent);
        addNonNull(commandList, "--clear-cache", clearCache);

        addNonNull(commandList, "--input-file", inputFile);
        addNonNull(commandList, "--input-file-comment", inputFileComment);
        addNonNull(commandList, "--input-file-delete", inputFileDelete);

        addToggle(commandList, "--quiet", quiet);
        addToggle(commandList, "--verbose", verbose);
        addToggle(commandList, "--get-urls", getUrls);
        addToggle(commandList, "--resolve-urls", resolveUrls);
        addToggle(commandList, "--dump-json", dumpJson);
        addToggle(commandList, "--simulate", simulate);
        addToggle(commandList, "--extractor-info", extractorInfo);
        addToggle(commandList, "--list-keywords", listKeywords);
        addNonNull(commandList, "--error-file", errorFile);
        addToggle(commandList, "--list-modules", listModules);
        addToggle(commandList, "--list-extractors", listExtractors);
        addNonNull(commandList, "--write-log", writeLog);
        addToggle(commandList, "--write-pages", writePages);

        addNonNull(commandList, "--limit-rate", limitRate);
        addNonNull(commandList, "--retries", retries);
        addNonNull(commandList, "--http-timeout", httpTimeout);
        addNonNull(commandList, "--sleep", sleep);
        addNonNull(commandList, "--sleep-request", sleepRequest);
        addNonNull(commandList, "--sleep-extractor", sleepExtractor);
        addNonNull(commandList, "--filesize-min", filesizeMin);
        addNonNull(commandList, "--filesize-max", filesizeMax);
        addNonNull(commandList, "--chunk-size", chunkSize);
        addToggle(commandList, "--no-part", noPart);
        addToggle(commandList, "--no-skip", noSkip);
        addToggle(commandList, "--no-mtime", noMtime);
        addToggle(commandList, "--no-download", noDownload);
        addToggle(commandList, "--no-postprocessors", noPostprocessors);
        addToggle(commandList, "--no-check-certificate", noCheckCertificate);

        addNonNull(commandList, "--option", option);
        addNonNull(commandList, "--config", config);
        addNonNull(commandList, "--config-yaml", configYaml);
        addNonNull(commandList, "--config-toml", configToml);
        addToggle(commandList, "--config-create", configCreate);
        addToggle(commandList, "--config-ignore", configIgnore);

        addNonNull(commandList, "--username", username);
        addNonNull(commandList, "--password", password);
        addToggle(commandList, "--netrc", netrc);

        addNonNull(commandList, "--cookies", cookies);
        addNonNull(commandList, "--cookies-export", cookiesExport);
        addNonNull(commandList, "--cookies-from-browser", cookiesFromBrowser);

        addNonNull(commandList, "--download-archive", downloadArchive);
        addNonNull(commandList, "--abort", abort);
        addNonNull(commandList, "--terminate", terminate);
        addNonNull(commandList, "--range", range);
        addNonNull(commandList, "--chapter-range", chapterRange);
        addNonNull(commandList, "--filter", filter);
        addNonNull(commandList, "--chapter-filter", chapterFilter);

        addNonNull(commandList, "--postprocessor", postprocessor);
        addNonNull(commandList, "--postprocessor-option", postprocessorOption);
        addToggle(commandList, "--write-metadata", writeMetadata);
        addToggle(commandList, "--write-info-json", writeInfoJson);
        addToggle(commandList, "--write-tags", writeTags);
        addToggle(commandList, "--zip", zip);
        addToggle(commandList, "--cbz", cbz);
        addNonNull(commandList, "--mtime", mtime);
        addNonNull(commandList, "--ugoira", ugoira);
        addNonNull(commandList, "--exec", exec);
        addNonNull(commandList, "--exec-after", execAfter);

        return commandList;
    }

    private void addNonNull(List<String> list, String command, Object value) {
        if (value != null) {
            list.add(command);
            list.add(value.toString());
        }
    }

    private void addToggle(List<String> list, String command, Boolean value) {
        if (Boolean.TRUE.equals(value)) {
            list.add(command);
        }
    }
}
