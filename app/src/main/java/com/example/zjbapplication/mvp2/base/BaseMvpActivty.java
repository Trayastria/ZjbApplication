package com.example.zjbapplication.mvp2.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Created by zhaojiangbo on 2020/3/21 16:45
 * ...
 * FUNCTION : ...
 * @author zhaojiangbo
 */
public abstract class BaseMvpActivty<V,  T extends BasePresenter<V>> extends Activity {
    protected T mPresent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresent = creatPresent();
        if (mPresent != null){
            mPresent.attachView((V) this);
        }


        initView();
    }


    protected abstract T creatPresent();

    protected abstract int getLayoutId();

    protected void initView(){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresent != null){
            mPresent.dettachView();
        }

    }
}
