package com.lutech.themelt.model;

import android.graphics.drawable.Drawable;

public class Applist {
    private String name;
    Drawable icon;
    private String packages;
    public Applist(String name, Drawable icon, String packages) {
        this.name = name;
        this.icon = icon;
        this.packages = packages;
    }
    public String getName() {
        return name;
    }
    public Drawable getIcon() {
        return icon;
    }
    public String getPackages() {
        return packages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }
}