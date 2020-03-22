package com.example.zjbapplication.testvlayout.presenter;

import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;
import com.example.zjbapplication.testvlayout.model.InterViewModel;
import com.example.zjbapplication.testvlayout.view.InterViewInter;
import com.zjb.zjbbaseframework.common.mvp.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojiangbo on 2020/3/22 17:13
 * <p>
 * FUNCTION : ...
 */
public class InterViewPresenter implements IBasePresenter<InterViewInter> {
    private InterViewInter interViewInter;
    private InterViewModel model;

    public InterViewPresenter(InterViewInter interViewInter) {
        attachView(interViewInter);
        model = new InterViewModel(this);
    }

    @Override
    public void attachView(InterViewInter view) {
        this.interViewInter = view;
    }

    @Override
    public void detachView() {
        interViewInter = null;
    }


    public void getMyGoodsData(){
        model.getMyGoodsData();

    }

    public void setMyGoodsData(List<MyGoodsBean> goodsBeans){
        if (interViewInter != null && !interViewInter.isFinishing()){
            interViewInter.setMyGoodsData(goodsBeans);
        }
    }

    public void getMyGoodsData2(){
       model.getMyGoodsData2();
    }

    public void updataMyTestData(List<MyGoodsBean> goodsBeans){
        if (interViewInter != null && !interViewInter.isFinishing()){
            interViewInter.setMyTestData(goodsBeans);
        }
    }
}
