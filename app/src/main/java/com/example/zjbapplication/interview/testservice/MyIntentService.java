package com.example.zjbapplication.interview.testservice;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

/**
 * Created by zhaojiangbo on 2020/3/18 18:25
 * hu：
 * FUNCTION : ...
 */
public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * 此方法 会自动开启一个子线程 在这个方法中 可以执行耗时操作
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        for (int i = 0 ; i<500000; i++){
            System.out.println("MyIntentService: "+ i);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
