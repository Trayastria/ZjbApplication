package com.example.zjbapplication.interview.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

/**
 * Created by zhaojiangbo on 2020/3/20 18:33
 * hu：
 * FUNCTION : ...
 */
public class TwoThread {
    private static final String TAG = "TwoThread";
    Context context;
    private Handler handler;
    public TwoThread(Context mContext){
        this.context = mContext;
    }

    public void handlerDemoByTwoWorkThread(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                Looper.prepare();
                handler = new Handler(){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        Log.w(TAG, "hanMeiMei receiver message: " + ((String) msg.obj));
                        Toast.makeText(context, ((String) msg.obj), Toast.LENGTH_SHORT).show();

                    }
                };
                Looper.loop();
            }
        };

        Thread lileiThread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = handler.obtainMessage();
                msg.obj = "Hi MeiMei";
                handler.sendMessage(msg);
            }
        };

        thread.setName("韩梅梅 Thread");
        thread.start();

        lileiThread.setName("李雷 Thread");
        lileiThread.start();
    }





}
