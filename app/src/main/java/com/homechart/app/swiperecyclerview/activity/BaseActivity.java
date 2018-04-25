package com.homechart.app.swiperecyclerview.activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.homechart.app.swiperecyclerview.R;
import com.jaeger.library.StatusBarUtil;


public abstract class BaseActivity extends FragmentActivity {
    private boolean destroyed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutResId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimaryDark),0);
        }else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimaryDark),0);
        }
        initExtraBundle();
        initData(savedInstanceState);
        initListener();
    }
    /**
     * 获取布局的Id
     *
     */
    protected abstract int getLayoutResId();

    /**
     * 获取bundle数据
     */
    protected void initExtraBundle() {
    }

    /**
     * 初始化数据操作
     *
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 设置监听
     */
    protected void initListener() {
    }

    public boolean isDestroyed() {
        return destroyed;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

}
