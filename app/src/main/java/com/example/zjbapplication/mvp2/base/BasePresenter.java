package com.example.zjbapplication.mvp2.base;

import java.lang.ref.WeakReference;

/**
 * Created by zhaojiangbo on 2020/3/21 16:38
 * ...
 * FUNCTION : ...
 */
public abstract class BasePresenter<T> {
    protected WeakReference<T> mViewRef;
    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    public T getmViewRef() {
        return mViewRef.get();
    }

    public boolean isViewAttach(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public void dettachView(){
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
