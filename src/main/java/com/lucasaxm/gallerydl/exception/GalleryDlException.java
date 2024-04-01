package com.lucasaxm.gallerydl.exception;

import com.lucasaxm.gallerydl.options.GalleryDlResult;
import lombok.Getter;

@Getter
public class GalleryDlException extends RuntimeException {

    private GalleryDlResult galleryDlResult;

    public GalleryDlException(String message, GalleryDlResult galleryDlResult) {
        super(message);
        this.galleryDlResult = galleryDlResult;
    }

    public GalleryDlException(String message, GalleryDlResult galleryDlResult, Throwable cause) {
        super(message, cause);
        this.galleryDlResult = galleryDlResult;
    }

    public GalleryDlException(String message, Throwable cause) {
        super(message, cause);
    }

    public GalleryDlException(String message) {
        super(message);
    }
}
