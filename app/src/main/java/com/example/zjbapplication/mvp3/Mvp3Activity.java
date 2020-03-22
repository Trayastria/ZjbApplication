package com.example.zjbapplication.mvp3;

import android.view.View;
import android.widget.TextView;

import com.example.zjbapplication.R;
import com.example.zjbapplication.mvp3.presenter.MvpPresenter;
import com.example.zjbapplication.mvp3.view.MvpView;
import com.zjb.zjbbaseframework.common.BaseMvpActivity;

/**
 * Created by zhaojiangbo on 2020/3/21 19:38
 * ...
 * FUNCTION : ...
 */
public class Mvp3Activity extends BaseMvpActivity<MvpView, MvpPresenter> implements MvpView, View.OnClickListener {
    private TextView tv_mvp;
    @Override
    protected MvpPresenter creatPresenter() {
        return new MvpPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    protected void initView() {
        super.initView();
        tv_mvp = findViewById(R.id.tv_mvp);
    }

    @Override
    protected void initAction() {
        findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                mPresenter.setStringData();
                break;
        }
    }

    @Override
    public void updataView(String str) {
        tv_mvp.setText(str);
    }

}
