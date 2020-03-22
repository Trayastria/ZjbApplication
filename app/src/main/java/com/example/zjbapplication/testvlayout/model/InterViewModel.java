package com.example.zjbapplication.testvlayout.model;

import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;
import com.example.zjbapplication.testvlayout.presenter.InterViewPresenter;
import com.zjb.zjbbaseframework.common.mvp.BaseModel;
import com.zjb.zjbbaseframework.common.mvp.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojiangbo on 2020/3/22 21:04
 * <p>
 * FUNCTION : ...
 */
public class InterViewModel extends BaseModel<InterViewPresenter> {
    public InterViewModel(InterViewPresenter presenter) {
        super(presenter);
    }

    public void getMyGoodsData(){
        List<MyGoodsBean> goodsBeans = new ArrayList<>();
        for (int i = 0; i<50; i++){
            MyGoodsBean myGoodsBean = new MyGoodsBean();
            myGoodsBean.setTitle("这是第"+i+"条标题");
            goodsBeans.add(myGoodsBean);
        }
        mPresenter.setMyGoodsData(goodsBeans);

    }

    public void getMyGoodsData2(){
        List<MyGoodsBean> goodsBeans = new ArrayList<>();
        for (int i = 0; i<16; i++){
            MyGoodsBean myGoodsBean = new MyGoodsBean();
            myGoodsBean.setTitle("第"+i);
            goodsBeans.add(myGoodsBean);
        }
        mPresenter.updataMyTestData(goodsBeans);
    }


}
