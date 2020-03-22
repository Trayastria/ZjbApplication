package com.example.zjbapplication.testvlayout.presenter;

import com.example.zjbapplication.mvp3.base.IBasePresenter;
import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;
import com.example.zjbapplication.testvlayout.view.InterViewInter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojiangbo on 2020/3/22 17:13
 * <p>
 * FUNCTION : ...
 */
public class InterViewPresenter implements IBasePresenter<InterViewInter> {
    private InterViewInter interViewInter;

    public InterViewPresenter(InterViewInter interViewInter) {
        attachView(interViewInter);
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
        List<MyGoodsBean> goodsBeans = new ArrayList<>();
        for (int i = 0; i<50; i++){
            MyGoodsBean myGoodsBean = new MyGoodsBean();
            myGoodsBean.setTitle("这是第"+i+"条标题");
            goodsBeans.add(myGoodsBean);
        }
        if (interViewInter != null && !interViewInter.isFinishing()){
            interViewInter.setMyGoodsData(goodsBeans);
        }

    }

    public void getMyGoodsData2(){
        List<MyGoodsBean> goodsBeans = new ArrayList<>();
        for (int i = 0; i<16; i++){
            MyGoodsBean myGoodsBean = new MyGoodsBean();
            myGoodsBean.setTitle("第"+i);
            goodsBeans.add(myGoodsBean);
        }
        if (interViewInter != null && !interViewInter.isFinishing()){
            interViewInter.setMyTestData(goodsBeans);
        }
    }
}
