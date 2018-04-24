package com.homechart.app.swiperecyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.homechart.app.swiperecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bt_page_flush)
    Button btPageFlush;
    @BindView(R.id.bt_single_loader)
    Button btLoaderFlush;
    @BindView(R.id.bt_multi_loader)
    Button bt_multi_loader;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_page_flush, R.id.bt_single_loader, R.id.bt_multi_loader})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_page_flush:
                Intent intentPage = new Intent(this, PageFlushActivity.class);
                startActivity(intentPage);
                break;
            case R.id.bt_single_loader:
                Intent intentSingleLoader = new Intent(this, SingleFlushActivity.class);
                startActivity(intentSingleLoader);
                break;
            case R.id.bt_multi_loader:
                Intent intentMultiLoader = new Intent(this, MultiFlushActivity.class);
                startActivity(intentMultiLoader);
                break;
        }
    }
}
