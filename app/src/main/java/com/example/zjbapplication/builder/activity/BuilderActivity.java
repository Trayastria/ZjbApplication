package com.example.zjbapplication.builder.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zjbapplication.R;
import com.example.zjbapplication.builder.Builder;
import com.example.zjbapplication.builder.ComputerBuilder;
import com.example.zjbapplication.builder.Director;
import com.example.zjbapplication.builder.Macbook;
import com.example.zjbapplication.builder.XiaomiAirBook;
import com.example.zjbapplication.builder.listener.CustomViewInterface;
import com.example.zjbapplication.builder.view.CustomView;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder
 * @ClassName: BuilderActivity
 * @Description: java类作用描述
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/7 16:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/7 16:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BuilderActivity extends AppCompatActivity implements View.OnClickListener {
    private CustomView customView;
    private LinearLayout ll_contain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
        customView = findViewById(R.id.customView);
        findViewById(R.id.button_builder).setOnClickListener(this);
        findViewById(R.id.button_builder1).setOnClickListener(this);
        findViewById(R.id.button_builder2).setOnClickListener(this);
        ll_contain = findViewById(R.id.ll_contain);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_builder:
                Builder builder = new ComputerBuilder();
                builder.setComputer(new Macbook());
                Director director = new Director(builder);
                director.construct("败家之眼主板", "败家之眼显示器");
                System.out.println("Computer Info: " + builder.create().toString());

                Builder builder1 = new ComputerBuilder();
                builder1.setComputer(new XiaomiAirBook()).buildOs().buildBoard("xiaomi 主板").buildDisplay("xiaomi 显示器");
                System.out.println("Computer Info1: " + builder1.create().toString());
                break;
            case R.id.button_builder1:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setIcon(R.drawable.ic_launcher_background).setMessage("这是一条信息").setTitle("标题").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setPositiveButton("qux",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int d) {

                    }
                }).create().show();
                break;
            case R.id.button_builder2:
                showView();
                break;
        }
    }

    private void showView(){
        CustomView.Builder builder = new CustomView.Builder(this);
        ;
//        customView.setBuilder(new CustomView.Builder()
//                );

        ll_contain.addView(builder.setTitle("自定义title")
                .setMsg("自定义msg：大苏打实打实大苏打萨达萨达萨达萨达范德萨范德萨范德萨范德萨发达的撒范德萨范德萨范德萨范德萨发")
                .setConfigStr("确定", new CustomViewInterface.OnConfirmListener() {
                    @Override
                    public void onConfirm() {
                        Toast.makeText(BuilderActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelStr("取消")
                .creat());
    }
}
