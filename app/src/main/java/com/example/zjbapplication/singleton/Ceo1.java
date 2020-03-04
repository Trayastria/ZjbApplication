package com.example.zjbapplication.singleton;

/**
 * 单例模式-懒汉模式
 */
public class Ceo1 extends Staff{
    private static Ceo1 instance;
    private Ceo1(){
        System.out.println("懒汉模式初始化==============");
    }
    public static synchronized Ceo1 getInstance() {
        if (instance == null){
            instance = new Ceo1();
        }
        System.out.println("懒汉模式调用==============");
        return instance;
    }

    @Override
    public void work() {
        //管理副总裁
    }
}
