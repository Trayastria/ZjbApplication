package com.example.zjbapplication.interview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.zjbapplication.R;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * Created by zhaojiangbo on 2020/3/18 16:18
 * DOU BAN：88445710
 * FUNCTION : ...
 */
public class InterViewActivity extends Activity implements View.OnClickListener {
    private TestBroadcastRececer rececer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
        findViewById(R.id.button_register_broadcast).setOnClickListener(this);
        findViewById(R.id.button_send_broadcast).setOnClickListener(this);
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
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (rececer != null){
            rececer.unRegisterReceiver();
        }
    }
}
