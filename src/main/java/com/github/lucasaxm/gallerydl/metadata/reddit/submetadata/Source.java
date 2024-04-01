package com.github.lucasaxm.gallerydl.metadata.reddit.submetadata;

import com.github.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Source extends SubMetadata {
    private String url;
    private int width;
    private int height;
}
