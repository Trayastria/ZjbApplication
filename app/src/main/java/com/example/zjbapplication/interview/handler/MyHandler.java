package com.example.zjbapplication.interview.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;

/**
 * Created by zhaojiangbo on 2020/3/20 10:37
 * DOU BAN：88445710
 * FUNCTION : ...
 */
public class MyHandler {
    public Context mContext;
    public MyHandler(Context mContext){
        this.mContext = mContext;
    }

    private final int MESSAGE_WHAT = 1002;
    /**
     * 用于接收子线程中传送过来的消息
     */
    private Handler handler = new Handler(){
        //handleMessage用于接收具体的消息，消息存放在Message中
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MESSAGE_WHAT:
                    //在主线程做视图的上的更新
                    Toast.makeText(mContext,""+msg.obj,Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    public void sendMsg(){
        /**
         * 开启子线程，做耗时操作
         */
        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message = handler.obtainMessage(MESSAGE_WHAT);
                message.obj = "I am message from work thread";
                handler.sendMessage(message);
            }
        }.start();
    }
}
