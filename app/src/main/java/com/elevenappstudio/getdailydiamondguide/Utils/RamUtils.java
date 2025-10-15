package com.elevenappstudio.getdailydiamondguide.Utils;

import android.app.ActivityManager;
import android.content.Context;
import java.text.DecimalFormat;

public class RamUtils {
    private ActivityManager activityManager;
    private Context context;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private ActivityManager.MemoryInfo memoryInfo;

    private float bytesToGB(long j) {
        return ((float) j) / 1.07374182E9f;
    }

    public RamUtils(Context context2) {
        this.context = context2;
        initializeMemoryInfo();
    }

    private void initializeMemoryInfo() {
        this.activityManager = (ActivityManager) this.context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
        this.memoryInfo = memoryInfo2;
        this.activityManager.getMemoryInfo(memoryInfo2);
    }

    public String getTotalMemory() {
        return this.decimalFormat.format((double) bytesToGB(this.memoryInfo.totalMem)) + " GB";
    }

    public String getAvailableMemory() {
        return this.decimalFormat.format((double) bytesToGB(this.memoryInfo.availMem)) + " GB";
    }

    public String getUsedMemory() {
        return this.decimalFormat.format((double) bytesToGB(this.memoryInfo.totalMem - this.memoryInfo.availMem)) + " GB";
    }

    public String getPercentUsedString() {
        return Math.round((((float) (this.memoryInfo.totalMem - this.memoryInfo.availMem)) / ((float) this.memoryInfo.totalMem)) * 100.0f) + "%";
    }

    public int getPercentUsed() {
        return Math.round((((float) (this.memoryInfo.totalMem - this.memoryInfo.availMem)) / ((float) this.memoryInfo.totalMem)) * 100.0f);
    }
}
