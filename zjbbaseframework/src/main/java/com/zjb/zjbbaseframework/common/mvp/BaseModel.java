package com.zjb.zjbbaseframework.common.mvp;

/**
 * Created by zhaojiangbo on 2020/3/22 21:00
 * <p>
 * FUNCTION : ...
 */
public abstract class BaseModel<P extends IBasePresenter> {
    protected P mPresenter;
    public BaseModel(P presenter){
        this.mPresenter = presenter;
    }
}
