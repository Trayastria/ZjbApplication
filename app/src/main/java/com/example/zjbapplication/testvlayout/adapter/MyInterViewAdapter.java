package com.example.zjbapplication.testvlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.zjbapplication.R;
import com.example.zjbapplication.testvlayout.adapter.holder.MyInterViewViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 18:31
 * <p>
 * FUNCTION : ...
 */
public class MyInterViewAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    public MyInterViewAdapter(Context context){
        this.mContext = context;
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyInterViewViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_interview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyInterViewViewHolder viewViewHolder = (MyInterViewViewHolder) holder;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
