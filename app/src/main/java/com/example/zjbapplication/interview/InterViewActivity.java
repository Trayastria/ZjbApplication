package com.example.zjbapplication.interview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.view.View;

import com.example.zjbapplication.R;
import com.example.zjbapplication.interview.handler.MyHandler;
import com.example.zjbapplication.interview.handler.TwoThread;
import com.example.zjbapplication.interview.testservice.MyBinderService;
import com.example.zjbapplication.interview.testservice.MyIntentService;
import com.example.zjbapplication.interview.testservice.MyService;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * Created by zhaojiangbo on 2020/3/18 16:18
 * hu：
 * FUNCTION : ...
 */
public class InterViewActivity extends Activity implements View.OnClickListener {
    private TestBroadcastRececer rececer;

    private MyBinderService.MyBinder myBinder;
    private boolean isServiceBind = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
        findViewById(R.id.button_register_broadcast).setOnClickListener(this);
        findViewById(R.id.button_send_broadcast).setOnClickListener(this);

        findViewById(R.id.button_start_service).setOnClickListener(this);
        findViewById(R.id.button_stop_service).setOnClickListener(this);

        findViewById(R.id.button_start_intentservice).setOnClickListener(this);

        findViewById(R.id.button_bind_service).setOnClickListener(this);
        findViewById(R.id.button_unbind_service).setOnClickListener(this);

        findViewById(R.id.button_handler).setOnClickListener(this);
        findViewById(R.id.button_handler_1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_register_broadcast:
                if (rececer == null){
                    rececer = new TestBroadcastRececer(this);
                    rececer.registerReceiver();
                }
                break;
            case R.id.button_send_broadcast:
                Intent intent = new Intent("androimmmmk.mknk");
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                break;
            case R.id.button_start_service:
                Intent starService = new Intent(this, MyService.class);
                startService(starService);
                break;
            case R.id.button_stop_service:
                Intent stopService = new Intent(this, MyService.class);
                stopService(stopService);
                break;
            case R.id.button_start_intentservice:
                Intent startIntentService = new Intent(this, MyIntentService.class);
                startService(startIntentService);
                break;
            case R.id.button_bind_service:
                Intent bindIntent = new Intent(this, MyBinderService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.button_unbind_service:
                if (isServiceBind){
                    unbindService(connection);
                    isServiceBind = false;
                }

                break;
            case R.id.button_handler:
                MyHandler myHandler = new MyHandler(this);

                myHandler.sendMsg();
                break;
            case R.id.button_handler_1:
                TwoThread twoThread = new TwoThread(this);
                twoThread.handlerDemoByTwoWorkThread();
                break;
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyBinderService.MyBinder) iBinder;
            myBinder.getProgress();
            myBinder.startDownload();
            isServiceBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isServiceBind = false;
        }
    };


    Messenger mService = null;
    private ServiceConnection connection1 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mService = new Messenger(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (rececer != null){
            rececer.unRegisterReceiver();
        }
        if (isServiceBind){
            unbindService(connection);
        }
    }
}
