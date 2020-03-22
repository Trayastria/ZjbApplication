package com.zjb.zjbbaseframework.common.mvp;

/**
 * Created by zhaojiangbo on 2020/3/21 19:35
 * ...
 * FUNCTION : ...
 */
public interface IBasePresenter<V extends IBaseView> {
    void attachView(V view);

    void detachView();
}
