package com.homechart.app.swiperecyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.homechart.app.swiperecyclerview.R;
import com.homechart.app.swiperecyclerview.adapter.LoaderFlushAdapter;
import com.homechart.app.swiperecyclerview.adapter.MultiFlushAdapter;
import com.homechart.app.swiperecyclerview.entity.DataEntity;
import com.homechart.app.swiperecyclerview.entity.InfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 多布局
 * Created by gumenghao on 2018/4/24.
 */

public class MultiFlushActivity
        extends BaseActivity
        implements SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.rl_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.srl_loader)
    SwipeRefreshLayout mSrlLoader;

    private int tagID = 0;
    private LinearLayoutManager mLayoutManager;
    private MultiFlushAdapter mMultiFlushAdapter;
    private List<DataEntity> dataList = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_multiflush;
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMultiFlushAdapter = new MultiFlushAdapter(dataList);
        mRecyclerView.setAdapter(mMultiFlushAdapter);
        mSrlLoader.setRefreshing(true);
        onRefresh();

    }

    @Override
    protected void initListener() {
        super.initListener();
        mSrlLoader.setOnRefreshListener(this);
        mMultiFlushAdapter.setOnLoadMoreListener(this, mRecyclerView);
    }

    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void refreshData() {
        dataList.clear();
        for (int i = 0; i < 20; i++)
            dataList.add(new DataEntity(i + "", new InfoBean("right")));
        tagID = 20;
        mMultiFlushAdapter.setNewData(dataList);
    }

    @Override
    public void onLoadMoreRequested() {
        mHandler.sendEmptyMessageDelayed(1, 1000);
    }

    private void loadData() {

        int i = tagID;
        List<DataEntity> loadList = new ArrayList<>();
        for (; i < tagID + 20; i++)
            loadList.add(new DataEntity(i + "", new InfoBean("left")));
        tagID = loadList.size() + dataList.size();
        mMultiFlushAdapter.addData(loadList);

    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int whatCode = msg.what;
            if (whatCode == 0) {
                refreshData();
                mSrlLoader.setRefreshing(false);
            } else {
                loadData();
                if (tagID > 60) {
                    mMultiFlushAdapter.loadMoreEnd();
                } else {
                    mMultiFlushAdapter.loadMoreComplete();
                }
            }

        }
    };


}
