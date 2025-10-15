package com.elevenappstudio.getdailydiamondguide.Modal;

import android.graphics.drawable.Drawable;

public class PrimaryItems {
    Drawable imageRes;
    String[] spinner;
    int spinnerItemSelected;
    String subText;
    String title;

    public PrimaryItems(String str, String str2, String[] strArr, int i) {
        this.title = str;
        this.subText = str2;
        this.spinner = strArr;
        this.spinnerItemSelected = i;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubText() {
        return this.subText;
    }

    public Drawable getImageRes() {
        return this.imageRes;
    }

    public String[] getSpinner() {
        return this.spinner;
    }

    public int getSpinnerItemSelected() {
        return this.spinnerItemSelected;
    }
}


