package com.example.zjbapplication.testvlayout.adapter.holder;

import android.view.View;
import android.widget.Button;

import com.example.zjbapplication.R;
import com.zjb.zjbbaseframework.common.net.HttpClientUtil;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 18:32
 * <p>
 * FUNCTION : ...
 */
public class MyInterViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Button button_net1;
    public MyInterViewViewHolder(@NonNull View itemView) {
        super(itemView);
        button_net1 = itemView.findViewById(R.id.button_net1);
        button_net1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_net1:
                HttpClientUtil httpClientUtil = new HttpClientUtil();
                httpClientUtil.excute("http://v.juhe.cn/toutiao/index?type=top&key=2f41498b35e69877fc56dc96776e5d1f");

                break;
            default:
                break;
        }
    }
}
