package com.zjb.zjbbaseframework.common.net;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhaojiangbo on 2020/3/24 11:01
 * <p>
 * FUNCTION : ...
 */
public class BaseOkHttpUtil {
    public BaseOkHttpUtil() throws IOException {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        Call call =
                httpClient.newCall(new Request.Builder().build());
        call.execute();
    }
}
