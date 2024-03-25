package com.lutech.themelt.model;



public class ThemesModel {

     private int id;

    private String name ;
    private int download;
    private String img;
    private String type;
    private String days;
    private String imgwallpaper;
    private String author;

    public ThemesModel(int id, String name, int download, String img) {
        this.id = id;
        this.name = name;
        this.download = download;
        this.img = img;
    }

    public ThemesModel(int id, String name, int download, String img, String imgwallpaper) {
        this.id = id;
        this.name = name;
        this.download = download;
        this.img = img;
        this.imgwallpaper = imgwallpaper;
    }

    public ThemesModel(int id, String name, int download, String img, String type, String days, String imgwallpaper, String author) {
        this.id = id;
        this.name = name;
        this.download = download;
        this.img = img;
        this.type = type;
        this.days = days;
        this.imgwallpaper = imgwallpaper;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDownload() {
        return download;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getImgwallpaper() {
        return imgwallpaper;
    }

    public void setImgwallpaper(String imgwallpaper) {
        this.imgwallpaper = imgwallpaper;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
