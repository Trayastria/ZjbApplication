package com.example.zjbapplication.mvp3.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Created by zhaojiangbo on 2020/3/21 19:33
 * ...
 * FUNCTION : ...
 */
public abstract class BaseMvpActivity<V extends IBaseView, P extends IBasePresenter<V>> extends Activity {
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        this.mPresenter = creatPresenter();
        initView();
        initAction();
    }

    protected abstract P creatPresenter();

    protected abstract int getLayoutId();

    protected void initView(){

    }

    protected void initAction(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
