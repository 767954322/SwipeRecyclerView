package com.homechart.app.swiperecyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.homechart.app.swiperecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_page_flush)
    TextView tvPageFlush;
    @BindView(R.id.tv_single_loader)
    TextView tvLoaderFlush;
    @BindView(R.id.tv_multi_loader)
    TextView tvMultiLoader;
    @BindView(R.id.tv_addheader)
    TextView tvAddHeader;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_page_flush, R.id.tv_single_loader, R.id.tv_multi_loader,R.id.tv_addheader})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_page_flush:
                Intent intentPage = new Intent(this, PageFlushActivity.class);
                startActivity(intentPage);
                break;
            case R.id.tv_single_loader:
                Intent intentSingleLoader = new Intent(this, SingleFlushActivity.class);
                startActivity(intentSingleLoader);
                break;
            case R.id.tv_multi_loader:
                Intent intentMultiLoader = new Intent(this, MultiFlushActivity.class);
                startActivity(intentMultiLoader);
                break;
            case R.id.tv_addheader:
                Intent intentAddHeader = new Intent(this, AddHeaderActivity.class);
                startActivity(intentAddHeader);
                break;
        }
    }
}
