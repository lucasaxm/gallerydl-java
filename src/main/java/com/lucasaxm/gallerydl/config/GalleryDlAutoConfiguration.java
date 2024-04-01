package com.lucasaxm.gallerydl.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.lucasaxm.gallerydl.GalleryDl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(GalleryDl.class)
public class GalleryDlAutoConfiguration {

    @Value("${gallerydl.path}")
    private String galleryDlPath;

    @Bean
    public GalleryDl galleryDl() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return new GalleryDl(galleryDlPath, mapper);
    }
}
