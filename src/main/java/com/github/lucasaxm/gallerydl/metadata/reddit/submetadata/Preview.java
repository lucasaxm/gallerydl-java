package com.github.lucasaxm.gallerydl.metadata.reddit.submetadata;

import com.github.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Preview extends SubMetadata {
    private List<Image> images;
    private boolean enabled;
}
