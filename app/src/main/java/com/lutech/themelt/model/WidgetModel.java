package com.lutech.themelt.model;

public class WidgetModel {
    int id;
    String type ;
    String imgsmall;
    String imgbig;

    public WidgetModel() {
    }

    public WidgetModel(int id, String type, String imgsmall, String imgbig) {
        this.id = id;
        this.type = type;
        this.imgsmall = imgsmall;
        this.imgbig = imgbig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgsmall() {
        return imgsmall;
    }

    public void setImgsmall(String imgsmall) {
        this.imgsmall = imgsmall;
    }

    public String getImgbig() {
        return imgbig;
    }

    public void setImgbig(String imgbig) {
        this.imgbig = imgbig;
    }
}
