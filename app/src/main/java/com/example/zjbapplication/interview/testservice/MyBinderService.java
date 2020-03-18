package com.example.zjbapplication.interview.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by zhaojiangbo on 2020/3/18 17:37
 * DOU BAN：88445710
 * FUNCTION : ...
 */
public class MyBinderService extends Service {
    public static final String TAG = "MyService";

    private MyBinder myBinder = new MyBinder();

    /**
     * 创建服务时调用
     * 只有在未创建时 才会调用， 如果已创建了该服务， 那么就不会再调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.w(TAG, "onCreate");
    }

    /**
     * 执行服务的操作
     * 每次启动服务的时候 都会调用
     * 因为该服务是运行在主线程中的， 所以尽量不要直接在该方法中 执行耗时操作， 需要开启子线程来执行耗时操作
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.w(TAG, "onStartCommand");
        //开启子线程来执行 耗时操作，可以避免卡顿，避免ARN
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    System.out.println("shuju: " + i);
                }
                stopSelf();
            }
        }).start();
//        for (int i = 0 ; i<500000; i++){
//            System.out.println("shuju: "+ i);
//        }
        return super.onStartCommand(intent, flags, startId);
    }

    //销毁服务时使用
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy");
    }

    //onBind()此方法是Service类中的唯一的抽象方法，所以必须在子类中实现此方法
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyBinder extends Binder {
        public void startDownload() {
            Log.w("TAG", "startDownload() executed");
            for (int i = 0; i < 500000; i++) {
                System.out.println("shuju: " + i);
            }
        }

        public int getProgress() {
            Log.w("TAG", "getProgress() executed");
            return 0;
        }
    }
}
