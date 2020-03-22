package com.example.zjbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.zjbapplication.builder.activity.BuilderActivity;
import com.example.zjbapplication.houserenting.Tennat;
import com.example.zjbapplication.imageloader.activity.ImageActivity;
import com.example.zjbapplication.interview.InterViewActivity;
import com.example.zjbapplication.mvp.MVPActivity;
import com.example.zjbapplication.mvp3.Mvp3Activity;
import com.example.zjbapplication.mvp2.MvpActivitya;
import com.example.zjbapplication.singleton.TestCom;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.btn_interview).setOnClickListener(this);
        findViewById(R.id.btn_mvp).setOnClickListener(this);
        findViewById(R.id.btn_mvptwo).setOnClickListener(this);
        findViewById(R.id.btn_mvp_three).setOnClickListener(this);
        findViewById(R.id.btn_interview2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, ImageActivity.class);
                startActivity(intent);
                break;
            case R.id.button1:
                Tennat tennat = new Tennat();
                tennat.rentRoom();
                break;
            case R.id.button2:
                TestCom testCom = new TestCom();
//                testCom.show();
                break;
            case R.id.button3:
                Intent intent1 = new Intent(this, BuilderActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_interview:
                Intent intent_interview = new Intent(this, InterViewActivity.class);
                startActivity(intent_interview);
                break;
            case R.id.btn_mvp:
                Intent intent_mvp = new Intent(this, MVPActivity.class);
                startActivity(intent_mvp);
                break;
            case R.id.btn_mvptwo:
                Intent intent_mvptwo = new Intent(this, MvpActivitya.class);
                startActivity(intent_mvptwo);
                break;
            case R.id.btn_mvp_three:
                Intent intent_mvpthree = new Intent(this, Mvp3Activity.class);
                startActivity(intent_mvpthree);
                break;
            case R.id.btn_interview2:
                Intent intent_interview_2 = new Intent(this, com.example.zjbapplication.testvlayout.activity.InterViewActivity.class);
                startActivity(intent_interview_2);
                break;
            default:
                break;
        }
    }
}
