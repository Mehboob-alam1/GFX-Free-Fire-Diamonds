package com.elevenappstudio.getdailydiamondguide;

import com.elevenappstudio.getdailydiamondguide.Modal.AllAppsInfo;
import com.elevenappstudio.getdailydiamondguide.Modal.CleanAppsInfo;
import com.elevenappstudio.getdailydiamondguide.Modal.DashboardAppsInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static String CLEANABLE_CACHE = "0";
    public static String GAME_SPINNER_ITEMS = "game_spinner_item";
    public static String LAST_DEVICE_CLEANED_TIME = "lastDeviceCleanedTime";
    public static String SHIZUKU_VIDEO_LINK = "https://t.me/c/1892153183/32";
    public static List<AllAppsInfo> allAppsInfoList = new ArrayList();
    public static List<CleanAppsInfo> allCleanAppList = new ArrayList();
    public static Map<String, DashboardAppsInfo> dashboardAppsInfoMap = new HashMap();
    public static List<String> dashboardAppsPkgNamesList = new ArrayList();
}


