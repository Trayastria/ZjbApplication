package com.example.zjbapplication.testvlayout.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zjbapplication.R;
import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 19:57
 * <p>
 * FUNCTION : ...
 */
public class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Context mContext;
    private TextView tv_mygoods_title;
    private MyGoodsBean goodsBean;

    public TestViewHolder(@NonNull View itemView, Context mContext) {
        super(itemView);
        this.mContext = mContext;
        tv_mygoods_title = itemView.findViewById(R.id.tv_mygoods_title);
        tv_mygoods_title.setOnClickListener(this);
    }

    public void onBindView(MyGoodsBean goodsBean) {
        this.goodsBean = goodsBean;
        tv_mygoods_title.setText(goodsBean.getTitle() + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_mygoods_title:
                Toast.makeText(mContext, ""+goodsBean.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
