package com.github.lucasaxm.gallerydl.metadata.tiktok.submetadata;

import com.github.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thumbnail extends SubMetadata {
    private String url;
    private int width;
    private int height;
    private String id;
    private String resolution;
}
