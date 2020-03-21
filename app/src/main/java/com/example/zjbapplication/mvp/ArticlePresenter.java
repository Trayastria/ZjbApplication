package com.example.zjbapplication.mvp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.zjbapplication.mvp.base.BasePresenter;
import com.example.zjbapplication.mvp.model.ArticleModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * Created by zhaojiangbo on 2020/3/20 20:42
 * hu：
 * FUNCTION :作为View和Model的中间人
 */
public class ArticlePresenter {
    //view的接口，代表了view的接口角色
    private ArticleViewInterface articleViewInterface;
    private ArticleModel articleModel;

    private Context mContext;

    List<Article> articles = new ArrayList<>();

    NoLeakHandler noLeakHandler = new NoLeakHandler(ArticlePresenter.this);

    public ArticlePresenter(Context context, ArticleViewInterface articleViewInterface) {
        this.mContext = context;
        this.articleViewInterface = articleViewInterface;
        articleModel = new ArticleModel();
    }
    int j = 0;

    public void getData() {
        if (articleViewInterface == null) {
            return;
        }
        articleViewInterface.showLoading();


        Log.w("xiancheng", "kaiqi");
        new Thread(){
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
                    j++;
                }
                articleModel.setArticles(j);

                Log.w("xiancheng", "fasong");
                Message message = noLeakHandler.obtainMessage(12);

                noLeakHandler.sendMessage(message);
            }
        }.start();
    }



    private static class NoLeakHandler extends Handler {
        //持有弱引用MainActivity,GC回收时会被回收掉.
        private WeakReference<ArticlePresenter> weakReference;
        public NoLeakHandler(ArticlePresenter activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ArticlePresenter articlePresenter = weakReference.get();
            articlePresenter.articleViewInterface.hideLoading();
            articlePresenter.articleViewInterface.showArticles(articlePresenter.articleModel.getArticles());
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case 12:
                    articleViewInterface.hideLoading();
                    articleViewInterface.showArticles(articleModel.getArticles());
                    break;
            }

        }
    };

}
