package com.example.zjbapplication.imageloader.imageload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.example.zjbapplication.imageloader.listener.ImageCacheListner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DiskCache implements ImageCacheListner {
    //本地的缓存路径
    static String cacheDir = Environment.getExternalStorageDirectory().getAbsolutePath()+"/ZjbApplication/cache/";

    public DiskCache(){
        File file = new File(cacheDir);
        //判断文件夹是否存在，不存在则需要创建
        if (!file.exists()){
            file.mkdirs();
        }
    }

    /**
     * 获取本地图片
     * @param url 图片的地址
     * @return Bitmap对象
     */
    @Override
    public Bitmap get(String url) {
        Log.e("sd卡缓存","--------------------获取---------------------");
        return BitmapFactory.decodeFile(cacheDir+url.substring(url.lastIndexOf("/"), url.length()));
    }

    /**
     * 存储图片对象
     * @param url
     * @param bitmap
     */
    @Override
    public void set(String url, Bitmap bitmap) {
        Log.e("sd卡缓存","--------------------写入---------------------");

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir+url.substring(url.lastIndexOf("/"), url.length()));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            CloseUtils.close(fileOutputStream);
        }
    }
}
