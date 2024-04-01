package com.github.lucasaxm.gallerydl.metadata.twitter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.lucasaxm.gallerydl.metadata.Metadata;
import com.github.lucasaxm.gallerydl.metadata.twitter.submetadata.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tweet extends Metadata {

    private int width;
    private int height;
    private String description;

    @JsonProperty("tweet_id")
    private long tweetId;

    @JsonProperty("retweet_id")
    private long retweetId;

    @JsonProperty("quote_id")
    private long quoteId;

    @JsonProperty("reply_id")
    private long replyId;

    @JsonProperty("conversation_id")
    private long conversationId;

    private String date;
    private User author;
    private User user;
    private User mentions;
    private String lang;
    private String source;
    private boolean sensitive;

    @JsonProperty("favorite_count")
    private int favoriteCount;

    @JsonProperty("quote_count")
    private int quoteCount;

    @JsonProperty("reply_count")
    private int replyCount;

    @JsonProperty("retweet_count")
    private int retweetCount;

    private String content;
    private int count;
    private int num;
}
