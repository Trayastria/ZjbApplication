package com.example.zjbapplication.builder;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder
 * @ClassName: Builder
 * @Description: java类作用描述
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/7 15:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/7 15:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class Builder {
    public abstract Builder setComputer(Computer computer);
    //设置主机
    public abstract Builder buildBoard(String board);
    //设置显示器
    public abstract Builder buildDisplay(String display);
    //设置操作系统
    public abstract Builder buildOs();
    //创建Computer
    public abstract Computer create();
}
