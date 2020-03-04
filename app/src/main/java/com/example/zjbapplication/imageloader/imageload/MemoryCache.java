package com.example.zjbapplication.imageloader.imageload;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

import com.example.zjbapplication.imageloader.listener.ImageCacheListner;

public class MemoryCache implements ImageCacheListner {
    private static MemoryCache memoryCache = new MemoryCache();
    //图片缓存
    LruCache<String, Bitmap> mImageCache;
    //构造
    private MemoryCache(){
        initImageCache();
    }

    public static MemoryCache getMemoryCache() {
        return memoryCache;
    }

    //初始化
    private void initImageCache(){
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;

        mImageCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        Log.e("内存缓存","--------------------获取---------------------");
        if (mImageCache != null){
            return mImageCache.get(url);
        }
        return null;
    }

    @Override
    public void set(String url, Bitmap bitmap) {
        Log.e("内存缓存","--------------------写入---------------------");
        if (mImageCache != null){
            mImageCache.put(url,bitmap);
        }
    }
}
