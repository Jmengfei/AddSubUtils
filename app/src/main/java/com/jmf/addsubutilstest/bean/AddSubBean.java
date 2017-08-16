package com.jmf.addsubutilstest.bean;

/**
 * Created by 贾梦飞 on 2017/8/15 9:37.
 * QQ:821176301
 * 微信：j821176301
 * desc：
 */

public class AddSubBean {
    private String name;    // 物品的名称
    private int value;      // 物品当前值
    private int imageId;

    public AddSubBean(String name, int value, int imageId) {
        this.name = name;
        this.value = value;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
