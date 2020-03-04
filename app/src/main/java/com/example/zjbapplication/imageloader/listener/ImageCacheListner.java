package com.example.zjbapplication.imageloader.listener;

import android.graphics.Bitmap;

public interface ImageCacheListner {
    Bitmap get(String url);

    void set(String url, Bitmap bitmap);
}
