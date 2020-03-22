package com.example.zjbapplication.mvp3.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 19:14
 * <p>
 * FUNCTION : ...
 */
public abstract class BaseDelegateAdapter<T, VH extends RecyclerView.ViewHolder> extends DelegateAdapter.Adapter<VH> {
    protected List<T> mData;
    protected Context mContext;

    public BaseDelegateAdapter(Context context){
        this.mContext = context;
    }

    public void setDataResource(List<T> mData){
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void clearData(){
        if (mData != null){
            mData.clear();
            notifyDataSetChanged();
        }
    }

    protected int getDataSize(){
        return mData != null ? mData.size() : 0;
    }

    /**
     * 获取View对象
     * @param layoutId
     * @param parent
     * @return
     */
    protected View getRootView(int layoutId, ViewGroup parent){
        return LayoutInflater.from(mContext).inflate(layoutId, parent, false);
    }
}
