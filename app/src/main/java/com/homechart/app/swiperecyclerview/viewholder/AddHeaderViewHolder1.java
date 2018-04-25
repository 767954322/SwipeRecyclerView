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
public class AddHeaderViewHolder1 {

    @BindView(R.id.cv_header1)
    public  CardView cvHeader;
    @BindView(R.id.tv_header1)
    public  TextView tvHeader;

    public AddHeaderViewHolder1(View headerRootView) {

        ButterKnife.bind(this, headerRootView);


    }
}
