package com.elevenappstudio.getdailydiamondguide.Utils;

import rikka.shizuku.Shizuku;

public class ShizukuPermission {
    static int SHIZUKU_PERMISSION_REQUEST_CODE = 512;

    public static boolean isShizukuGranted() {
        if (Shizuku.isPreV11()) {
            return false;
        }
        if (Shizuku.checkSelfPermission() == 0) {
            return true;
        }
        if (Shizuku.shouldShowRequestPermissionRationale()) {
            return false;
        }
        Shizuku.requestPermission(SHIZUKU_PERMISSION_REQUEST_CODE);
        return false;
    }
}
