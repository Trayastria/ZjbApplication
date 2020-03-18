package com.example.zjbapplication.builder;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder
 * @ClassName: MacbookBuilder
 * @Description: 具体的Builder类，继承了抽象类：Builder
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/7 15:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/7 15:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ComputerBuilder extends Builder{
    //通过Computer的子类Macbook 创建Computer类
    private Computer mComputer = new Macbook();

    public ComputerBuilder(){

    }

    @Override
    public Builder setComputer(Computer computer) {
        this.mComputer = computer;
        return this;
    }

    @Override
    public Builder buildBoard(String board) {
        mComputer.setBoard(board);
        return this;
    }

    @Override
    public Builder buildDisplay(String display) {
        mComputer.setmDisplay(display);
        return this;
    }

    @Override
    public Builder buildOs() {
        mComputer.setmOs();
        return this;
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
