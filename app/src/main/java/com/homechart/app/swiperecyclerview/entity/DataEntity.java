package com.homechart.app.swiperecyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by gumenghao on 2018/4/25.
 */

public class DataEntity implements MultiItemEntity {


    public static final int TYOEONE = 0;
    public static final int TYOTWO = 1;

    private String text;
    private InfoBean infoBean;


    public DataEntity(String text, InfoBean infoBean) {
        this.text = text;
        this.infoBean = infoBean;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public InfoBean getInfoBean() {
        return infoBean;
    }

    public void setInfoBean(InfoBean infoBean) {
        this.infoBean = infoBean;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "text='" + text + '\'' +
                ", infoBean=" + infoBean +
                '}';
    }

    @Override
    public int getItemType() {
        if (infoBean.getTag().equals("left")) {
            return TYOEONE;
        } else {
            return TYOTWO;
        }
    }
}
