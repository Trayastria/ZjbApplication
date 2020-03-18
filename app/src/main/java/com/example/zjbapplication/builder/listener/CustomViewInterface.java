package com.example.zjbapplication.builder.listener;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder.listener
 * @ClassName: CustomViewInterface
 * @Description: java类作用描述
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/8 15:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/8 15:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface CustomViewInterface {
    interface OnConfirmListener{
        void onConfirm();
    }

    interface OnCancelListener{
        void onCancel();
    }
}
