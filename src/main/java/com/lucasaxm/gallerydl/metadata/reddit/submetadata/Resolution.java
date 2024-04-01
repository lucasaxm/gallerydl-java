package com.lucasaxm.gallerydl.metadata.reddit.submetadata;

import com.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resolution extends SubMetadata {
    private String url;
    private int width;
    private int height;
}
