package com.elevenappstudio.getdailydiamondguide.Modal;

import android.graphics.drawable.Drawable;

public class CleanAppsInfo {
    public Drawable appIcon;
    public String appName;
    public long cacheSize;
    public String formatCacheSize;
    public String pkgName;

    public CleanAppsInfo(String str, String str2, Drawable drawable, long j, String str3) {
        this.appName = str;
        this.pkgName = str2;
        this.appIcon = drawable;
        this.cacheSize = j;
        this.formatCacheSize = str3;
    }
}


