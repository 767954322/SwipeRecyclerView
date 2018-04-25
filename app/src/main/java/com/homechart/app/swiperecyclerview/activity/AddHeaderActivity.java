package com.homechart.app.swiperecyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.homechart.app.swiperecyclerview.R;
import com.homechart.app.swiperecyclerview.adapter.LoaderFlushAdapter;
import com.homechart.app.swiperecyclerview.viewholder.AddHeaderViewHolder1;
import com.homechart.app.swiperecyclerview.viewholder.AddHeaderViewHolder2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 单布局
 * Created by gumenghao on 2018/4/24.
 */

public class AddHeaderActivity
        extends BaseActivity
        implements SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener,
        View.OnClickListener,
        BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.rl_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.srl_loader)
    SwipeRefreshLayout mSrlLoader;

    private View mHeader1;
    private View mHeader2;
    private int tagID = 0;
    private LinearLayoutManager mLayoutManager;
    private AddHeaderViewHolder1 mAddHeaderViewHolder1;
    private AddHeaderViewHolder2 mAddHeaderViewHolder2;
    private LoaderFlushAdapter mLoaderFlushAdapter;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_loaderflush;
    }


    @Override
    protected void initData(Bundle savedInstanceState) {

        ButterKnife.bind(this);
        mHeader1 = LayoutInflater.from(AddHeaderActivity.this).inflate(R.layout.header_add1, null);
        mHeader2 = LayoutInflater.from(AddHeaderActivity.this).inflate(R.layout.header_add2, null);
        mAddHeaderViewHolder1 = new AddHeaderViewHolder1(mHeader1);
        mAddHeaderViewHolder2 = new AddHeaderViewHolder2(mHeader2);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mLoaderFlushAdapter = new LoaderFlushAdapter(R.layout.item_loader_flush, dataList);
        mLoaderFlushAdapter.addHeaderView(mHeader1);
        mLoaderFlushAdapter.addHeaderView(mHeader2);
        mRecyclerView.setAdapter(mLoaderFlushAdapter);
        mSrlLoader.setRefreshing(true);
        onRefresh();

    }

    @Override
    protected void initListener() {
        super.initListener();

        mAddHeaderViewHolder1.cvHeader.setOnClickListener(this);
        mAddHeaderViewHolder2.cvHeader.setOnClickListener(this);
        mLoaderFlushAdapter.setOnItemClickListener(this);
        mSrlLoader.setOnRefreshListener(this);
        mLoaderFlushAdapter.setOnLoadMoreListener(this, mRecyclerView);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cv_header1:
                Toast.makeText(AddHeaderActivity.this, "你摸我头干嘛～", Toast.LENGTH_LONG).show();
                mLoaderFlushAdapter.removeHeaderView(mHeader1);
                break;

            case R.id.cv_header2:
                Toast.makeText(AddHeaderActivity.this, "你还摸我头～", Toast.LENGTH_LONG).show();
                mLoaderFlushAdapter.removeHeaderView(mHeader2);
                break;

        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(AddHeaderActivity.this, "点击第" + position + "条数据 -> -> "
                + dataList.get(position), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void refreshData() {
        dataList.clear();
        for (int i = 0; i < 20; i++)
            dataList.add(i + "");
        tagID = 20;
        mLoaderFlushAdapter.setNewData(dataList);
    }

    @Override
    public void onLoadMoreRequested() {
        mHandler.sendEmptyMessageDelayed(1, 1000);
    }

    private void loadData() {

        int i = tagID;
        List<String> loadList = new ArrayList<>();
        for (; i < tagID + 20; i++)
            loadList.add(i + "");
        tagID = loadList.size() + dataList.size();
        mLoaderFlushAdapter.addData(loadList);

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
                    mLoaderFlushAdapter.loadMoreEnd();
                } else {
                    mLoaderFlushAdapter.loadMoreComplete();
                }
            }

        }
    };

}
