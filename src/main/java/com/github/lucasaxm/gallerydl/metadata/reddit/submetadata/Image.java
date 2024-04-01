package com.github.lucasaxm.gallerydl.metadata.reddit.submetadata;

import com.github.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Image extends SubMetadata {
    private Source source;
    private List<Resolution> resolutions;
    private String id;
}
