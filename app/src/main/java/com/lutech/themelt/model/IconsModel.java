package com.lutech.themelt.model;




public class IconsModel {

    private int id;
    private String imgsmal;
    private String imgbig;
    private int id_theme;
    private int type;
    private int Status;

    public IconsModel(int id, String imgsmal, int id_theme, int status) {
        this.id = id;
        this.imgsmal = imgsmal;
        this.id_theme = id_theme;
        Status = status;
    }

    public IconsModel(int id, String imgsmal, String imgbig, int id_theme, int type, int status) {
        this.id = id;
        this.imgsmal = imgsmal;
        this.imgbig = imgbig;
        this.id_theme = id_theme;
        this.type = type;
        Status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }


    public String getImgsmal() {
        return imgsmal;
    }

    public void setImgsmal(String imgsmal) {
        this.imgsmal = imgsmal;
    }

    public String getImgbig() {
        return imgbig;
    }

    public void setImgbig(String imgbig) {
        this.imgbig = imgbig;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getId_theme() {
        return id_theme;
    }

    public void setId_theme(int id_theme) {
        this.id_theme = id_theme;
    }
}
