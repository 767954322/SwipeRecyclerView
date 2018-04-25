package com.homechart.app.swiperecyclerview.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.homechart.app.swiperecyclerview.R;
import com.homechart.app.swiperecyclerview.entity.DataEntity;
import com.homechart.app.swiperecyclerview.entity.InfoBean;

import java.util.List;

/**
 * Created by gumenghao on 2018/4/25.
 */

public class MultiFlushAdapter extends BaseMultiItemQuickAdapter<DataEntity, BaseViewHolder> {


    public MultiFlushAdapter(@Nullable List<DataEntity> data) {
        super(data);
        addItemType(DataEntity.TYOEONE, R.layout.item_multi_left);
        addItemType(DataEntity.TYOTWO, R.layout.item_multi_right);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataEntity item) {
        switch (helper.getItemViewType()) {
            case DataEntity.TYOEONE:
                helper.setText(R.id.tv_item_left, item.getText());
                break;
            case DataEntity.TYOTWO:
                helper.setText(R.id.tv_item_right, item.getText());
                break;
        }
    }
}
