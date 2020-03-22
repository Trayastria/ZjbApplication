package com.example.zjbapplication.mvp2;

import com.example.zjbapplication.R;
import com.example.zjbapplication.mvp2.base.BaseMvpActivty;
import com.example.zjbapplication.mvp2.presenter.MyPresenter;
import com.example.zjbapplication.mvp2.view.MyViewInterface;

/**
 * Created by zhaojiangbo on 2020/3/21 16:53
 * ...
 * FUNCTION : ...
 */
public class MvpActivitya extends BaseMvpActivty<MyViewInterface, MyPresenter<MyViewInterface>> implements MyViewInterface{
    @Override
    protected MyPresenter creatPresent() {
        return new MyPresenter<>(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    public void showArticles(int in) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
