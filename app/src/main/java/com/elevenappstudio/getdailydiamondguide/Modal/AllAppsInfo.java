package com.elevenappstudio.getdailydiamondguide.Modal;

import android.graphics.drawable.Drawable;

public class AllAppsInfo {
    public Drawable appIcon;
    public String appName;
    public boolean isGame;
    public String pkgName;

    public AllAppsInfo(String str, String str2, Drawable drawable, boolean z) {
        this.appName = str;
        this.pkgName = str2;
        this.appIcon = drawable;
        this.isGame = z;
    }
}


