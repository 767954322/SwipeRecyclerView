package com.homechart.app.swiperecyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.homechart.app.swiperecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gumenghao on 2018/4/24.
 */

public class PageFlushActivity
        extends BaseActivity
        implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.srl_pager)
    SwipeRefreshLayout srlPager;
    @BindView(R.id.rl_list)
    RecyclerView rlList;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pageflush;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        srlPager.setRefreshing(true);
        onRefresh();
    }

    @Override
    protected void initListener() {
        super.initListener();
        srlPager.setOnRefreshListener(this);
    }


    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(0,1500);
    }
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            srlPager.setRefreshing(false);
            Toast.makeText(PageFlushActivity.this, "刷新啦，亲爱的", Toast.LENGTH_LONG).show();

        }
    };
}
