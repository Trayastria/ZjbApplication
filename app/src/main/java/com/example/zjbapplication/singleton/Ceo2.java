package com.example.zjbapplication.singleton;

/**
 * 单例模式-懒汉模式
 */
public class Ceo2 extends Staff{
    private static Ceo2 instance = null;
    private Ceo2(){
        System.out.println("DCL模式初始化==============");
    }
    public static Ceo2 getInstance() {
        if (instance == null){
            synchronized (Ceo2.class){
                if (instance == null){
                    instance = new Ceo2();
                }
            }
        }
        System.out.println("DCL模式调用==============");
        return instance;
    }

    @Override
    public void work() {
        //管理副总裁
    }
}
