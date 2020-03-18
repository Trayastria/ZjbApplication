package com.example.zjbapplication.builder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.zjbapplication.R;
import com.example.zjbapplication.builder.listener.CustomViewInterface;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder.view
 * @ClassName: CustomView
 * @Description: java类作用描述
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/7 18:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/7 18:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CustomView extends LinearLayout implements CustomViewInterface {
    private Context mContext;
    private TextView tv_title;
    private TextView tv_msg;
    private Button btn_config;
    private Button btn_cancel;
    public CustomView(Context context) {
        super(context);
        initView(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        initView(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        initView(context);
    }


    private void initView(Context context){
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_custom_dialog,null);
        addView(view);
        tv_title = view.findViewById(R.id.tv_title);
        tv_msg = view.findViewById(R.id.tv_msg);
        btn_config = view.findViewById(R.id.btn_config);
        btn_cancel = view.findViewById(R.id.btn_cancel);

    }

    private void setBuilder(Builder builder){
        if (null == builder){
            return;
        }
        tv_title.setText(builder.title);
        tv_msg.setText(builder.msg);
        btn_config.setText(builder.configStr);
        btn_cancel.setText(builder.cancelStr);
    }

    public Builder getBuilder(Context context){
        Builder builder = new Builder(context);
        return builder;
    }

    public static class Builder{
        private Context mContext;
        String title;
        String msg;
        String configStr;
        String cancelStr;
        public Builder(Context context){
            this.mContext = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setConfigStr(String configStr, OnConfirmListener onConfirmListener) {
            this.configStr = configStr;
            return this;
        }

        public Builder setCancelStr(String cancelStr) {
            this.cancelStr = cancelStr;
            return this;
        }

        public CustomView creat(){
            CustomView customView = new CustomView(mContext);
            customView.setBuilder(this);
            return customView;
        }
    }
}
