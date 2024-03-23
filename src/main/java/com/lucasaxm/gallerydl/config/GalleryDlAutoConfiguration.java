package com.lucasaxm.gallerydl.config;

import com.lucasaxm.gallerydl.GalleryDl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:gallerydl-java.properties")
public class GalleryDlAutoConfiguration {

    @Bean
    public GalleryDl galleryDl() {
        return new GalleryDl();
    }
}
