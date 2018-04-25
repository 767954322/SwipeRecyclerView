package com.homechart.app.swiperecyclerview.viewholder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.homechart.app.swiperecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gumenghao on 2018/4/25.
 */

public class AddHeaderViewHolder {

    @BindView(R.id.cv_header)
    CardView cvHeader;
    @BindView(R.id.tv_header)
    TextView tvHeader;

    public AddHeaderViewHolder(View headerRootView) {

        ButterKnife.bind(this,headerRootView);


    }
}
