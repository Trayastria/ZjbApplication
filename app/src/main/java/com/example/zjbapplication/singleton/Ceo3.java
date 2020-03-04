package com.example.zjbapplication.singleton;

/**
 * 单例模式-静态内部类
 */
public class Ceo3 extends Staff{

    private Ceo3(){
        System.out.println("DCL模式初始化==============");
    }
    public static Ceo3 getInstance(){
        return Ceo3Holder.ceo3;
    }
    @Override
    public void work() {
        //管理副总裁
    }

    private static class Ceo3Holder{
        private static final Ceo3 ceo3 = new Ceo3();
    }
}
