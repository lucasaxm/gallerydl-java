package com.lucasaxm.gallerydl.metadata.tiktok;

import com.lucasaxm.gallerydl.metadata.Metadata;
import com.lucasaxm.gallerydl.metadata.tiktok.submetadata.Format;
import com.lucasaxm.gallerydl.metadata.tiktok.submetadata.HttpHeaders;
import com.lucasaxm.gallerydl.metadata.tiktok.submetadata.Thumbnail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tiktok extends Metadata {
    private String id;
    private String title;
    private String description;
    private int duration;
    private long timestamp;
    private List<String> creators;
    private String channel;
    private String uploader;
    private String uploaderId;
    private int viewCount;
    private int likeCount;
    private int repostCount;
    private int commentCount;
    private String track;
    private String album;
    private List<String> artists;
    private String channelId;
    private String uploaderUrl;
    private List<Format> formats;
    private List<Thumbnail> thumbnails;
    private HttpHeaders httpHeaders;
    private String webpageUrl;
    private String originalUrl;
    private String webpageUrlBasename;
    private String webpageUrlDomain;
    private String extractor;
    private String extractorKey;
    private String thumbnail;
    private String displayId;
    private String fulltitle;
    private String durationString;
    private String uploadDate;
    private String creator;
    private long epoch;
    private String formatId;
    private String url;
    private int width;
    private int height;
    private String protocol;
    private String resolution;
    private String dynamicRange;
    private double aspectRatio;
    private String cookies;
    private String videoExt;
    private String audioExt;
    private String category;
    private String subcategory;
}
