package com.example.zjbapplication.builder;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder
 * @ClassName: Computer
 * @Description: java类作用描述
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/4 19:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/4 19:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class Computer {
    protected String board;//主机
    protected String mDisplay;//显示器
    protected String mOs;//操作系统

    //构造方法
    protected Computer() {

    }

    //设置cpu核心数
    public void setBoard(String board) {
        this.board = board;
    }

    //设置内存
    public void setmDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
    }

    //设置操作系统
    public abstract void setmOs();

    @Override
    public String toString() {
        return "Computer{" +
                "core='" + board + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
