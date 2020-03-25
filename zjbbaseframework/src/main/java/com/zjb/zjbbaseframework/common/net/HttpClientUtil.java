package com.zjb.zjbbaseframework.common.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by zhaojiangbo on 2020/3/23 20:10
 * <p>
 * FUNCTION : ...
 */
public class HttpClientUtil {


    public void excute(final String strUrl){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建Url对象
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    connection.getResponseCode();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
