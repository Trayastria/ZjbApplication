package com.example.zjbapplication.imageloader.imageload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.example.zjbapplication.imageloader.listener.ImageCacheListner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {

    //线程池，线程池为cpu的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {

    }

    /**
     * 调用方执行加载图片使用
     * @param imageCache
     * @param url       图片地址
     * @param imageView 图片载体
     */
    public void disPlayImage(final ImageCacheListner imageCache, final String url, final ImageView imageView) {
        if (imageCache != null){
            Bitmap bitmap = imageCache.get(url);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
        }
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                }
                imageCache.set(url, bitmap);
            }
        });
    }


    /**
     * 下载图片使用
     *
     * @param imageUrl 图片的地址
     * @return Bitmap对象
     */
    private Bitmap downloadImage(String imageUrl) {
        Log.e("无缓存", imageUrl);
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
