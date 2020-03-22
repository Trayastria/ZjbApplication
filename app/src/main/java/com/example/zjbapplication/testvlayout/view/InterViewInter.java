package com.example.zjbapplication.testvlayout.view;

import com.example.zjbapplication.mvp3.base.BaseView;
import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;

import java.util.List;

/**
 * Created by zhaojiangbo on 2020/3/22 17:12
 * <p>
 * FUNCTION : ...
 */
public interface InterViewInter extends BaseView {
    /**
     * 设置商品的数据
     * @param goodsBeans
     */
    void setMyGoodsData(List<MyGoodsBean> goodsBeans);

    void setMyTestData(List<MyGoodsBean> goodsBeans);
}
