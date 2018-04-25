package com.homechart.app.swiperecyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * Created by gumenghao on 2018/4/25.
 */

public class InfoBean
        implements Serializable {

    private String tag;

    public InfoBean(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
