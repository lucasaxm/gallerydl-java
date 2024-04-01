package com.github.lucasaxm.gallerydl.metadata;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lucasaxm.gallerydl.metadata.reddit.Submission;
import com.github.lucasaxm.gallerydl.metadata.twitter.Tweet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataWrapper {
    private static final ObjectMapper mapper = new ObjectMapper();
    private String category;
    private String subcategory;
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnySetter
    public void addAdditionalProperty(String key, Object value) {
        this.additionalProperties.put(key, value);
    }

    public Metadata convertToSpecificMetadata() {
        Metadata metadata = null;
        if ("twitter".equals(category)) {
            if ("tweet".equals(subcategory)) {
                metadata = mapper.convertValue(additionalProperties, Tweet.class);
            }
        } else if ("reddit".equals(category)) {
            if ("submission".equals(subcategory)) {
                metadata = mapper.convertValue(additionalProperties, Submission.class);
            }
        }
        if (metadata == null) {
            metadata = mapper.convertValue(additionalProperties, Unknown.class); // Provide UnknownMetadata class
        }
        // Fallback for unknown category/subcategory
        metadata.setCategory(category);
        metadata.setSubcategory(subcategory);
        return metadata;
    }
}