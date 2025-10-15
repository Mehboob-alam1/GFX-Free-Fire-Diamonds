package com.elevenappstudio.getdailydiamondguide.Modal;

import android.graphics.drawable.Drawable;

public class DashboardAppsInfo {
    public Drawable appIcon;
    public String appName;
    public String pkgName;

    public DashboardAppsInfo(String str, String str2, Drawable drawable) {
        this.appName = str;
        this.pkgName = str2;
        this.appIcon = drawable;
    }
}


