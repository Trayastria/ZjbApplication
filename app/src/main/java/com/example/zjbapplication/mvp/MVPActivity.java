package com.example.zjbapplication.mvp;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zjbapplication.R;

import java.util.List;

import androidx.annotation.Nullable;


/**
 * Created by zhaojiangbo on 2020/3/21 14:02
 * FUNCTION : ...
 */
public class MVPActivity extends Activity implements View.OnClickListener, ArticleViewInterface {
    private TextView tv_mvp;

    private ArticlePresenter presenter;

    //等待层开启
    private Dialog waitDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        findViewById(R.id.btn_start).setOnClickListener(this);

        tv_mvp = findViewById(R.id.tv_mvp);

        presenter = new ArticlePresenter(this, this);

        ProgressDialog dialog = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
        dialog.setMessage("稍等...");
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        waitDialog = dialog;
    }

    @Override
    public void showArticles(int articles) {
        tv_mvp.setText(articles+"");
    }

    @Override
    public void showLoading() {
        waitDialog.show();
    }

    @Override
    public void hideLoading() {
        waitDialog.hide();
    }

    @Override
    public void onClick(View v) {
        presenter.getData();
    }

}
