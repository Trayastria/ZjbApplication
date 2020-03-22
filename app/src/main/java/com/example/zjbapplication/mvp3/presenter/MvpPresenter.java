package com.example.zjbapplication.mvp3.presenter;

import com.example.zjbapplication.mvp3.view.MvpView;
import com.zjb.zjbbaseframework.common.mvp.IBasePresenter;

/**
 * Created by zhaojiangbo on 2020/3/21 19:41
 * ...
 * FUNCTION : ...
 */
public class MvpPresenter implements IBasePresenter<MvpView> {
    MvpView mvpView;

    public MvpPresenter(MvpView mvpView) {
        attachView(mvpView);
    }

    @Override
    public void attachView(MvpView view) {
        this.mvpView = view;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    public void setStringData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (mvpView != null && !mvpView.isFinishing()) {
                    mvpView.updataView(12333 + "");
                }
            }
        }).start();

    }
}
