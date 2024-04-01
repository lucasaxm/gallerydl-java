package com.github.lucasaxm.gallerydl.metadata.tiktok.submetadata;

import com.github.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Format extends SubMetadata {
    private String url;
    private String ext;
    private int width;
    private int height;
    private String protocol;
    private String resolution;
    private String dynamicRange;
    private double aspectRatio;
    private String cookies;
    private HttpHeaders httpHeaders;
    private String videoExt;
    private String audioExt;
    private String formatId;
    private String format;
}
