package com.example.zjbapplication.builder;

/**
 * @ProjectName: ZjbApplication
 * @Package: com.example.zjbapplication.builder
 * @ClassName: Macbook
 * @Description: 具体的电脑类
 * @Author: zhaojiangbo
 * @CreateDate: 2020/3/7 15:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/7 15:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Macbook extends Computer{
    public Macbook(){

    }

    @Override
    public void setmOs() {
        mOs = "Mac OS X 10.10";
    }


}
