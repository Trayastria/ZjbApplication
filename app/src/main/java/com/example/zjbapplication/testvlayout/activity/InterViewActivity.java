package com.example.zjbapplication.testvlayout.activity;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.zjbapplication.R;
import com.example.zjbapplication.testvlayout.adapter.MyGoodsAdapter;
import com.example.zjbapplication.testvlayout.adapter.MyInterViewAdapter;
import com.example.zjbapplication.testvlayout.adapter.TestAdapter;
import com.example.zjbapplication.testvlayout.bean.MyGoodsBean;
import com.example.zjbapplication.testvlayout.presenter.InterViewPresenter;
import com.example.zjbapplication.testvlayout.view.InterViewInter;
import com.zjb.zjbbaseframework.common.BaseMvpActivity;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhaojiangbo on 2020/3/22 17:09
 * <p>
 * FUNCTION : 使用mvp和vLayout构建的类
 */
public class InterViewActivity extends BaseMvpActivity<InterViewInter, InterViewPresenter> implements InterViewInter {

    private RecyclerView rl_interview;
    private DelegateAdapter delegateAdapter;
    private VirtualLayoutManager layoutManager;

    private MyGoodsAdapter myGoodsAdapter;
    private MyInterViewAdapter interViewAdapter;
    private TestAdapter testAdapter;

    @Override
    protected InterViewPresenter creatPresenter() {
        return new InterViewPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interview2;
    }

    @Override
    protected void initView() {
        super.initView();
        layoutManager = new VirtualLayoutManager(this, VirtualLayoutManager.VERTICAL);
        delegateAdapter = new DelegateAdapter(layoutManager, false);
        rl_interview = findViewById(R.id.rl_interview);
        rl_interview.setLayoutManager(layoutManager);
        rl_interview.setAdapter(delegateAdapter);


    }

    @Override
    protected void initData() {
        super.initData();
        interViewAdapter = new MyInterViewAdapter(this);
        delegateAdapter.addAdapter(interViewAdapter);

        testAdapter = new TestAdapter(this);
        delegateAdapter.addAdapter(testAdapter);

        myGoodsAdapter = new MyGoodsAdapter(this);
        delegateAdapter.addAdapter(myGoodsAdapter);

        mPresenter.getMyGoodsData();
        mPresenter.getMyGoodsData2();

    }

    @Override
    public void setMyGoodsData(List<MyGoodsBean> goodsBeans) {
        if (myGoodsAdapter != null && goodsBeans != null){
            myGoodsAdapter.setGoodsBeans(goodsBeans);
        }
    }

    @Override
    public void setMyTestData(List<MyGoodsBean> goodsBeans) {
        if (testAdapter == null || goodsBeans == null){
            return;
        }

        testAdapter.setDataResource(goodsBeans);
    }
}
