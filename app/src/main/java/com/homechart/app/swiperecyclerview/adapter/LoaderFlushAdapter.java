package com.homechart.app.swiperecyclerview.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.homechart.app.swiperecyclerview.R;

import java.util.List;

/**
 * Created by gumenghao on 2018/4/25.
 */

public class LoaderFlushAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public LoaderFlushAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_text, item);
    }
}
