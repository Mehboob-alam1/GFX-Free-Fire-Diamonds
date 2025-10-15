package com.elevenappstudio.getdailydiamondguide.Utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.text.DecimalFormat;

public class StorageUtils {
    private Context context;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private StatFs statFs;

    private float bytesToGB(long j) {
        return ((float) j) / 1.07374182E9f;
    }

    public StorageUtils(Context context2) {
        this.context = context2;
        initializeStorageInfo();
    }

    private void initializeStorageInfo() {
        this.statFs = new StatFs(Environment.getDataDirectory().getPath());
    }

    public String getTotalStorage() {
        return this.decimalFormat.format((double) bytesToGB(this.statFs.getTotalBytes())) + " GB";
    }

    public String getAvailableStorage() {
        return this.decimalFormat.format((double) bytesToGB(this.statFs.getAvailableBytes())) + " GB";
    }

    public String getUsedStorage() {
        return this.decimalFormat.format((double) bytesToGB(this.statFs.getTotalBytes() - this.statFs.getAvailableBytes())) + " GB";
    }

    public String getPercentUsedString() {
        long totalBytes = this.statFs.getTotalBytes();
        return Math.round((((float) (totalBytes - this.statFs.getAvailableBytes())) / ((float) totalBytes)) * 100.0f) + "%";
    }

    public int getPercentUsed() {
        long totalBytes = this.statFs.getTotalBytes();
        return Math.round((((float) (totalBytes - this.statFs.getAvailableBytes())) / ((float) totalBytes)) * 100.0f);
    }
}
