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
    @BindView(R.id.bt_loader_flush)
    Button btLoaderFlush;
    @BindView(R.id.bt_test)
    Button bt_test;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_page_flush, R.id.bt_loader_flush, R.id.bt_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_page_flush:
                Intent intentPage = new Intent(this,PageFlushActivity.class);
                startActivity(intentPage);
                break;
            case R.id.bt_loader_flush:
                Intent intentLoader = new Intent(this,LoaderFlushActivity.class);
                startActivity(intentLoader);
                break;
            case R.id.bt_test:
                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
