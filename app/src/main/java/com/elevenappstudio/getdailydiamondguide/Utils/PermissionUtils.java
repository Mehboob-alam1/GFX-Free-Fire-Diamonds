package com.elevenappstudio.getdailydiamondguide.Utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

public class PermissionUtils {
    public static boolean hasUsageStatsPermission(Context context) {
        return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
    }

    public static void requestUsageStatsPermission(Context context) {
        if (!hasUsageStatsPermission(context)) {
            context.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        } else {
            Log.d("PermissionUtils", "Usage Stats permission already granted");
        }
    }
}
