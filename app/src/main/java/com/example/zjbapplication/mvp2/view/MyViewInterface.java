package com.example.zjbapplication.mvp2.view;

/**
 * Created by zhaojiangbo on 2020/3/20 20:50
 * hu
 * FUNCTION : 主页面的逻辑接口，代表了View的接口角色，用于P层回调View的操作
 */
public interface MyViewInterface {
    //展示数据
    void showArticles(int in);

    void showLoading();

    void hideLoading();
}
