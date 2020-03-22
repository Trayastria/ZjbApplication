package com.example.zjbapplication.testvlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.zjbapplication.R;
import com.example.zjbapplication.testvlayout.adapter.holder.MyGoodsViewHolder;
import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 16:43
 * ...
 * FUNCTION : ...
 */
public class MyGoodsAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<MyGoodsBean> goodsBeans;
    public MyGoodsAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setGoodsBeans(List<MyGoodsBean> goodsBeans) {
        this.goodsBeans = goodsBeans;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyGoodsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_item_mygoods,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (goodsBeans == null || goodsBeans.size() < position){
            return;
        }
        MyGoodsViewHolder viewHolder = (MyGoodsViewHolder) holder;
        viewHolder.onBindView(goodsBeans.get(position));
    }

    @Override
    public int getItemCount() {
        return goodsBeans == null ? 0 : goodsBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
