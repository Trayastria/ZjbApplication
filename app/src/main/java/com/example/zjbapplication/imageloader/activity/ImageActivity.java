package com.example.zjbapplication.imageloader.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zjbapplication.R;
import com.example.zjbapplication.imageloader.imageload.DiskCache;
import com.example.zjbapplication.imageloader.imageload.DoubleCache;
import com.example.zjbapplication.imageloader.imageload.ImageLoader;
import com.example.zjbapplication.imageloader.imageload.MemoryCache;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView imageview;
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageLoader imageLoader2 = new ImageLoader();
    private MemoryCache memoryCache = MemoryCache.getMemoryCache();
    private DiskCache diskCache = new DiskCache();
    private DoubleCache doubleCache = new DoubleCache();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

        imageview = findViewById(R.id.imageview);
        imageview1 = findViewById(R.id.imageview1);
        imageview2 = findViewById(R.id.imageview2);
        imageview3 = findViewById(R.id.imageview3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                imageLoader2.disPlayImage(memoryCache,"http://www.njcb.com.cn/njcb/resource/cms/2020/03/img_pc_site/2020030217115088979.jpg", imageview);
                break;
            case R.id.button1:
                imageLoader2.disPlayImage(diskCache,"http://www.njcb.com.cn/njcb/resource/cms/2019/12/img_pc_site/2019123116564374556.jpg", imageview1);
                break;
            case R.id.button2:
                imageLoader2.disPlayImage(doubleCache,"http://www.njcb.com.cn/njcb/resource/cms/2019/09/img_pc_site/2019091814434091359.png", imageview2);
                break;
            case R.id.button3:
                Log.e("无缓存策略", "-----------------------------------------");
                imageLoader2.disPlayImage(memoryCache,"http://www.njcb.com.cn/njcb/resource/cms/2019/09/img_pc_site/2019091814434091359.png", imageview3);
                break;
        }
    }
}
