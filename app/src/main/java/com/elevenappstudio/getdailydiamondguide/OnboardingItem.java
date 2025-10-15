package com.elevenappstudio.getdailydiamondguide;

public class OnboardingItem {
    private int imageResId;
    private String title;
    private String subtitle;
    private String url;

    public OnboardingItem(int imageResId, String title, String subtitle, String url) {
        this.imageResId = imageResId;
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getUrl() {
        return url;
    }
}

