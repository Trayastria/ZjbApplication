package com.example.zjbapplication.mvp2.presenter;

import com.example.zjbapplication.mvp2.base.BasePresenter;
import com.example.zjbapplication.mvp2.view.MyViewInterface;

/**
 * Created by zhaojiangbo on 2020/3/21 17:43
 * ...
 * FUNCTION : ...
 */
public class MyPresenter<T> extends BasePresenter<MyViewInterface> {
    MyViewInterface myViewInterface;
    public MyPresenter(MyViewInterface myViewInterface){
        this.myViewInterface = myViewInterface;
    }
}
