package com.example.zjbapplication.interview.stringAAAstringbufferAAAstringbuilder;

/**
 * Created by zhaojiangbo on 2020/3/20 19:55
 * DOU BAN：88445710
 * FUNCTION : ...
 */
public class TestString {
    /**
     * StringBuilder和StringBuffer为可变字符序的
     *
     * StringBuilder具有写入速度快的优势、效率高、但是他不是线程安全的，可在单线程下使用
     *
     * StringBuffer是线程安全的，效率较低、推荐在多线程下 使用。
     */

    //对象定义完之后，就不可改变其现有的值
    String a = "a";

    //StringBuffer是线程安全的，是同步赋值的，append（）方法具有synchronized关键字
    StringBuffer stringBuffer = new StringBuffer();

    public void setStringBuffer() {
        stringBuffer.append(1);
        stringBuffer.append("1");
        stringBuffer.append(true);
        stringBuffer.append(12.3);
    }

    //StringBuilder不是线程安全的，不能被同步访问、赋值。
    StringBuilder stringBuilder = new StringBuilder();

    public void setStringBuilder() {
        stringBuilder.append(1);
        stringBuilder.append("1");
        stringBuilder.append(123.3).append(true).append(false);
    }
}
