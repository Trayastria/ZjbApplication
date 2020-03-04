package com.example.zjbapplication.singleton;

/**
 * 单例模式-饿汉模式
 */
public class Ceo extends Staff{
    //私有的获取类的对象
    private static Ceo ceo = new Ceo();
    //私有的构造方法
    private Ceo(){
        System.out.println("饿汉模式初始化==============");
    }

    //将类对象抛出
    public static Ceo getCeo() {
        System.out.println("饿汉模式调用==============");
        return ceo;
    }

    @Override
    public void work() {
        //管理副总裁
    }
}
