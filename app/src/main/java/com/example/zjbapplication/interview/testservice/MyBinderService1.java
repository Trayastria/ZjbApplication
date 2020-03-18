package com.example.zjbapplication.interview.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by zhaojiangbo on 2020/3/18 17:37
 * DOU BAN：88445710
 * FUNCTION : ...
 */
public class MyBinderService1 extends Service {
    public static final String TAG = "MyService";
    public static final int MSG_SAY_HELLO = 1;

    class LoacalHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case MSG_SAY_HELLO:
                    Log.e(TAG, "handleMessage : accepted!");
                    Messenger client = msg.replyTo;
                    Message replyMsg = Message.obtain(null,MSG_SAY_HELLO,0,0);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply", "ok~,I had receiver message from you! ");
                    replyMsg.setData(bundle);

                    try {
                        client.send(replyMsg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }

    Messenger messenger = new Messenger(new LoacalHandler());


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
        return messenger.getBinder();
    }

}
