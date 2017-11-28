package com.droid.tv.recommendapp;

import android.graphics.drawable.Drawable;

/**
 * Created by bhargava.gugamsetty on 03-11-2017.
 */

public class AppList {

    private String name;
    Drawable icon;

    public AppList(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }
}
