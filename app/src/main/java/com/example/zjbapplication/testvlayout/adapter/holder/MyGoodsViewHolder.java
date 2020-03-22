package com.example.zjbapplication.testvlayout.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.example.zjbapplication.R;
import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 17:59
 * <p>
 * FUNCTION : ...
 */
public class MyGoodsViewHolder extends RecyclerView.ViewHolder {
    private TextView tv_mygoods_title;
    public MyGoodsViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_mygoods_title = itemView.findViewById(R.id.tv_mygoods_title);
    }

    public void onBindView(MyGoodsBean bean){
        if (bean == null){
            return;
        }
        tv_mygoods_title.setText(bean.getTitle()+"");
    }
}
