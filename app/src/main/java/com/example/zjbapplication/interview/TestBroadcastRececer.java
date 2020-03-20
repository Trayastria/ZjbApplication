package com.example.zjbapplication.interview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * Created by zhaojiangbo on 2020/3/18 15:43
 * hu：
 * FUNCTION : ...
 */
public class TestBroadcastRececer {
    /**
     * 一、BrodCastReceiver分为静态注册 和 动态注册
     * 1、静态注册是在AndroidMenifest文件中通过标签声明注册的：
     *    优点是：不受其他组件的生命周期的影响，即使应用被关闭也能接收广播
     *    缺点是：耗电，占用内存。
     *    使用场景：需要时刻监听的广播
     * 2、动态注册是在代码中进行注册：
     *    优点是：运用灵活，容易易控，节省内存，耗电少
     *    缺点是：需要手动注销
     *    使用场景：用于特定时候监听的广播
     *
     * 二、广播分为有序广播和标准广播（normal）
     * 1、有序广播：
     *    是同步广播，广播接收具有接收顺序的广播，可被截断的广播。
     * 2、无须广播：
     *    完全的异步接收。在广播发出之后，所有的广播接收器几乎都会在同一时刻接收到该广播，无顺序可言。
     * 3、有序广播的实现：
     *    在发送广播时，在Intent中put相关数据，在接收广播的方法中 ， 通过intent获取到Extral的数据，通过实际情况 看是否需要注销广播
     *
     * 三、可以使用本地广播代替全局广播的使用。
     *
     */

    private Context mContext;
    private BroadcastReceiver receiver;
    private LocalBroadcastManager localBroadcastManager;

    public TestBroadcastRececer(Context mContext){
        this.mContext = mContext;
        localBroadcastManager = LocalBroadcastManager.getInstance(mContext);
    }

    //动态注册广播
    public void registerReceiver(){
        IntentFilter filter = new IntentFilter();
        filter.addAction("androimmmmk.mknk");
        receiver = new NetworkChangeReceiver();
        localBroadcastManager.registerReceiver(receiver, filter);
    }

    public void unRegisterReceiver(){
        localBroadcastManager.unregisterReceiver(receiver);
    }

    //广播的接收器
    public class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(mContext,"网络改变", Toast.LENGTH_SHORT).show();
        }
    }

}
