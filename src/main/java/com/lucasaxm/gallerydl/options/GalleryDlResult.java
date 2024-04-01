package com.lucasaxm.gallerydl.options;

import com.lucasaxm.gallerydl.metadata.Metadata;
import lombok.Data;

import java.util.List;

@Data
public class GalleryDlResult {
    private String url;
    private List<String> stdout;
    private List<String> stderr;
    private boolean downloaded;
    private int exitCode;
    private List<Metadata> metadata;
}
