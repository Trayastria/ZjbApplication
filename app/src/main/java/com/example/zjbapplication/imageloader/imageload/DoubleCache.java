package com.example.zjbapplication.imageloader.imageload;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.zjbapplication.imageloader.listener.ImageCacheListner;

public class DoubleCache implements ImageCacheListner {
    private MemoryCache imageCacheUtil = MemoryCache.getMemoryCache();
    private DiskCache diskCacheUtil = new DiskCache();

    /**
     * 首先先从内存中拿图片资源，内存中没有 ， 从sd卡中获取
     *
     * @return
     */
    @Override
    public Bitmap get(String url) {
        Log.e("双缓存", "------------------获取"+url);
        Bitmap bitmap = imageCacheUtil.get(url);
        if (bitmap == null) {
            Log.e("双缓存-获取内存缓存", "------------------无内存缓存-----------------------");
            bitmap = diskCacheUtil.get(url.substring(url.lastIndexOf("/"), url.length()));
        }
        return bitmap;
    }

    @Override
    public void set(String url, Bitmap bitmap) {
        Log.e("双缓存", "------------------写入"+url);
        imageCacheUtil.set(url, bitmap);
        diskCacheUtil.set(url.substring(url.lastIndexOf("/"), url.length()), bitmap);
    }
}
