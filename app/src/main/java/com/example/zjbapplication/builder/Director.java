package com.example.zjbapplication.builder;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder
 * @ClassName: Director
 * @Description: 负责构建Computer（电脑），起到组建、组装的作用
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/7 15:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/7 15:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Director {
    private Builder mBuilder;

    public Director(Builder builder){
        mBuilder = builder;
    }

    /**
     *  构造对象
     * @param board 主机
     * @param display 显示器
     */
    public void construct(String board, String display){
        if (null != mBuilder){
            mBuilder.buildBoard(board).buildDisplay(display).buildOs();
        }
    }
}
