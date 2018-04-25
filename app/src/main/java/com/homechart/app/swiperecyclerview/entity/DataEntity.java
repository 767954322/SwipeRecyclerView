package com.homechart.app.swiperecyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by gumenghao on 2018/4/25.
 */

public class DataEntity implements MultiItemEntity {

    private int itemType;

    private String text;
    public static final int TYOEONE = 0;
    public static final int TYOTWO = 1;

    public DataEntity(int itemType, String text) {
        this.itemType = itemType;
        this.text = text;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
