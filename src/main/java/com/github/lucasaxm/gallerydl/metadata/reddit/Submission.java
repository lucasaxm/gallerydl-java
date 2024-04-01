package com.github.lucasaxm.gallerydl.metadata.reddit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.lucasaxm.gallerydl.metadata.Metadata;
import com.github.lucasaxm.gallerydl.metadata.reddit.submetadata.AuthorFlairRichtext;
import com.github.lucasaxm.gallerydl.metadata.reddit.submetadata.Gildings;
import com.github.lucasaxm.gallerydl.metadata.reddit.submetadata.LinkFlairRichtext;
import com.github.lucasaxm.gallerydl.metadata.reddit.submetadata.Preview;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Submission extends Metadata {
    private String subreddit;
    private String selftext;
    private boolean saved;
    private int gilded;
    private boolean clicked;
    private String title;
    @JsonProperty("link_flair_richtext")
    private List<LinkFlairRichtext> linkFlairRichtext;
    @JsonProperty("subreddit_name_prefixed")
    private String subredditNamePrefixed;
    private boolean hidden;
    private int pwls;
    @JsonProperty("link_flair_css_class")
    private String linkFlairCssClass;
    private int downs;
    @JsonProperty("thumbnail_height")
    private int thumbnailHeight;
    @JsonProperty("parent_whitelist_status")
    private String parentWhitelistStatus;
    @JsonProperty("hide_score")
    private boolean hideScore;
    private String name;
    private boolean quarantine;
    @JsonProperty("link_flair_text_color")
    private String linkFlairTextColor;
    @JsonProperty("upvote_ratio")
    private double upvoteRatio;
    @JsonProperty("author_flair_background_color")
    private String authorFlairBackgroundColor;
    private int ups;
    private String domain;
    @JsonProperty("thumbnail_width")
    private int thumbnailWidth;
    @JsonProperty("is_original_content")
    private boolean isOriginalContent;
    @JsonProperty("author_fullname")
    private String authorFullname;
    @JsonProperty("is_reddit_media_domain")
    private boolean isRedditMediaDomain;
    @JsonProperty("is_meta")
    private boolean isMeta;
    @JsonProperty("link_flair_text")
    private String linkFlairText;
    @JsonProperty("can_mod_post")
    private boolean canModPost;
    private int score;
    @JsonProperty("is_created_from_ads_ui")
    private boolean isCreatedFromAdsUi;
    @JsonProperty("author_premium")
    private boolean authorPremium;
    private String thumbnail;
    private boolean edited;
    @JsonProperty("author_flair_richtext")
    private List<AuthorFlairRichtext> authorFlairRichtext;
    private Gildings gildings;
    @JsonProperty("post_hint")
    private String postHint;
    @JsonProperty("is_self")
    private boolean isSelf;
    @JsonProperty("subreddit_type")
    private String subredditType;
    private double created;
    @JsonProperty("link_flair_type")
    private String linkFlairType;
    private int wls;
    @JsonProperty("author_flair_type")
    private String authorFlairType;
    @JsonProperty("total_awards_received")
    private int totalAwardsReceived;
    @JsonProperty("allow_live_comments")
    private boolean allowLiveComments;
    @JsonProperty("url_overridden_by_dest")
    private String urlOverriddenByDest;
    private boolean archived;
    @JsonProperty("no_follow")
    private boolean noFollow;
    @JsonProperty("is_crosspostable")
    private boolean isCrosspostable;
    private boolean pinned;
    @JsonProperty("over_18")
    private boolean over18;
    private Preview preview;
    @JsonProperty("media_only")
    private boolean mediaOnly;
    @JsonProperty("link_flair_template_id")
    private String linkFlairTemplateId;
    @JsonProperty("can_gild")
    private boolean canGild;
    private boolean spoiler;
    private boolean locked;
    @JsonProperty("author_flair_text")
    private String authorFlairText;
    private boolean visited;
    @JsonProperty("subreddit_id")
    private String subredditId;
    @JsonProperty("author_is_blocked")
    private boolean authorIsBlocked;
    @JsonProperty("link_flair_background_color")
    private String linkFlairBackgroundColor;
    private String id;
    @JsonProperty("is_robot_indexable")
    private boolean isRobotIndexable;
    @JsonProperty("num_duplicates")
    private int numDuplicates;
    private String author;
    @JsonProperty("num_comments")
    private int numComments;
    @JsonProperty("send_replies")
    private boolean sendReplies;
    @JsonProperty("contest_mode")
    private boolean contestMode;
    @JsonProperty("author_patreon_flair")
    private boolean authorPatreonFlair;
    @JsonProperty("author_flair_text_color")
    private String authorFlairTextColor;
    private String permalink;
    @JsonProperty("whitelist_status")
    private String whitelistStatus;
    private boolean stickied;
    private String url;
    @JsonProperty("subreddit_subscribers")
    private int subredditSubscribers;
    @JsonProperty("created_utc")
    private double createdUtc;
    @JsonProperty("num_crossposts")
    private int numCrossposts;
    @JsonProperty("is_video")
    private boolean isVideo;
    private String date;
    private int num;
}
