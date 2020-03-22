package com.example.zjbapplication.testvlayout.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.zjbapplication.R;
import com.example.zjbapplication.testvlayout.adapter.holder.TestViewHolder;
import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;
import com.zjb.zjbbaseframework.common.vlayout.BaseDelegateAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 19:16
 * <p>
 * FUNCTION : ...
 */
public class TestAdapter extends BaseDelegateAdapter<MyGoodsBean, TestViewHolder> {
    public TestAdapter(Context context) {
        super(context);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper layoutHelper = new GridLayoutHelper(4);
        int px_20 = mContext.getResources().getDimensionPixelOffset(R.dimen.public_space_20px);
//        layoutHelper.setWeights(new float[]{50f, 50f});
        layoutHelper.setMargin(px_20, 0, px_20, 0);
        layoutHelper.setVGap(mContext.getResources().getDimensionPixelOffset(R.dimen.public_space_12px));
        layoutHelper.setHGap(px_20);
        layoutHelper.setBgColor(R.color.public_color_FFFFFF);
        return layoutHelper;
    }


    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TestViewHolder(getRootView(R.layout.recycler_item_test, parent),mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        if (mData == null){
            return;
        }
        holder.onBindView(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return getDataSize();
    }
}
