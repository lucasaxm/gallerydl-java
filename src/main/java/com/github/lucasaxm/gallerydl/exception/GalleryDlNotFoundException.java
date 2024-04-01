package com.github.lucasaxm.gallerydl.exception;

public class GalleryDlNotFoundException extends RuntimeException {

    public GalleryDlNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
