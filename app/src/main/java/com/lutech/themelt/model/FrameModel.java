package com.lutech.themelt.model;

public class FrameModel {
    int id;
    String imgsmall;
    String imgbig;

    public FrameModel(int id, String imgsmall, String imgbig) {
        this.id = id;
        this.imgsmall = imgsmall;
        this.imgbig = imgbig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
