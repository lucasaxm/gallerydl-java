package com.github.lucasaxm.gallerydl.metadata.twitter.submetadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.lucasaxm.gallerydl.metadata.SubMetadata;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends SubMetadata {
    private long id;
    private String name;
    private String nick;
    private String location;
    private String date;
    private boolean verified;
    private boolean protectedUser;
    private String profileBanner;

    @JsonProperty("profile_image")
    private String profileImage;

    @JsonProperty("favourites_count")
    private int favouritesCount;

    @JsonProperty("followers_count")
    private int followersCount;

    @JsonProperty("friends_count")
    private int friendsCount;

    @JsonProperty("listed_count")
    private int listedCount;

    @JsonProperty("media_count")
    private int mediaCount;

    @JsonProperty("statuses_count")
    private int statusesCount;

    private String description;
}
