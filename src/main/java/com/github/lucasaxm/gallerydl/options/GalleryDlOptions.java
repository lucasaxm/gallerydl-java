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
        if (filenameFormat != null) commandList.add("--filename");
        if (destination != null) commandList.add("--destination");
        if (directory != null) commandList.add("--directory");
        if (extractors != null) commandList.add("--extractors");
        if (proxy != null) commandList.add("--proxy");
        if (sourceAddress != null) commandList.add("--source-address");
        if (userAgent != null) commandList.add("--user-agent");
        if (clearCache != null) commandList.add("--clear-cache");
        if (inputFile != null) commandList.add("--input-file");
        if (inputFileComment != null) commandList.add("--input-file-comment");
        if (inputFileDelete != null) commandList.add("--input-file-delete");
        if (Boolean.TRUE.equals(quiet)) commandList.add("--quiet");
        if (Boolean.TRUE.equals(verbose)) commandList.add("--verbose");
        if (Boolean.TRUE.equals(getUrls)) commandList.add("--get-urls");
        if (Boolean.TRUE.equals(resolveUrls)) commandList.add("--resolve-urls");
        if (Boolean.TRUE.equals(dumpJson)) commandList.add("--dump-json");
        if (Boolean.TRUE.equals(simulate)) commandList.add("--simulate");
        if (Boolean.TRUE.equals(extractorInfo)) commandList.add("--extractor-info");
        if (Boolean.TRUE.equals(listKeywords)) commandList.add("--list-keywords");
        if (errorFile != null) commandList.add("--error-file");
        if (Boolean.TRUE.equals(listModules)) commandList.add("--list-modules");
        if (Boolean.TRUE.equals(listExtractors)) commandList.add("--list-extractors");
        if (writeLog != null) commandList.add("--write-log");
        if (Boolean.TRUE.equals(writePages)) commandList.add("--write-pages");
        if (limitRate != null) commandList.add("--limit-rate");
        if (retries != null) commandList.add("--retries");
        if (httpTimeout != null) commandList.add("--http-timeout");
        if (sleep != null) commandList.add("--sleep");
        if (sleepRequest != null) commandList.add("--sleep-request");
        if (sleepExtractor != null) commandList.add("--sleep-extractor");
        if (filesizeMin != null) commandList.add("--filesize-min");
        if (filesizeMax != null) commandList.add("--filesize-max");
        if (chunkSize != null) commandList.add("--chunk-size");
        if (Boolean.TRUE.equals(noPart)) commandList.add("--no-part");
        if (Boolean.TRUE.equals(noSkip)) commandList.add("--no-skip");
        if (Boolean.TRUE.equals(noMtime)) commandList.add("--no-mtime");
        if (Boolean.TRUE.equals(noDownload)) commandList.add("--no-download");
        if (Boolean.TRUE.equals(noPostprocessors)) commandList.add("--no-postprocessors");
        if (Boolean.TRUE.equals(noCheckCertificate)) commandList.add("--no-check-certificate");
        if (option != null) commandList.add("--option");
        if (config != null) commandList.add("--config");
        if (configYaml != null) commandList.add("--config-yaml");
        if (configToml != null) commandList.add("--config-toml");
        if (Boolean.TRUE.equals(configCreate)) commandList.add("--config-create");
        if (Boolean.TRUE.equals(configIgnore)) commandList.add("--config-ignore");
        if (username != null) commandList.add("--username");
        if (password != null) commandList.add("--password");
        if (Boolean.TRUE.equals(netrc)) commandList.add("--netrc");
        if (cookies != null) commandList.add("--cookies");
        if (cookiesExport != null) commandList.add("--cookies-export");
        if (cookiesFromBrowser != null) commandList.add("--cookies-from-browser");
        if (downloadArchive != null) commandList.add("--download-archive");
        if (abort != null) commandList.add("--abort");
        if (terminate != null) commandList.add("--terminate");
        if (range != null) commandList.add("--range");
        if (chapterRange != null) commandList.add("--chapter-range");
        if (filter != null) commandList.add("--filter");
        if (chapterFilter != null) commandList.add("--chapter-filter");
        if (postprocessor != null) commandList.add("--postprocessor");
        if (postprocessorOption != null) commandList.add("--postprocessor-option");
        if (Boolean.TRUE.equals(writeMetadata)) commandList.add("--write-metadata");
        if (Boolean.TRUE.equals(writeInfoJson)) commandList.add("--write-info-json");
        if (Boolean.TRUE.equals(writeTags)) commandList.add("--write-tags");
        if (Boolean.TRUE.equals(zip)) commandList.add("--zip");
        if (Boolean.TRUE.equals(cbz)) commandList.add("--cbz");
        if (mtime != null) commandList.add("--mtime");
        if (ugoira != null) commandList.add("--ugoira");
        if (exec != null) commandList.add("--exec");
        if (execAfter != null) commandList.add("--exec-after");

        return commandList;
    }
}
