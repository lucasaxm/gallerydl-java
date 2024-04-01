package com.lucasaxm.gallerydl.metadata.tiktok.submetadata;

import com.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpHeaders extends SubMetadata {
    private String userAgent;
    private String accept;
    private String acceptLanguage;
    private String secFetchMode;
    private String referer;
}
