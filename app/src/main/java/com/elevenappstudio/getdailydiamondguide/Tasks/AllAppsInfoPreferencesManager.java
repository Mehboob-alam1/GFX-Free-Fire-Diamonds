package com.elevenappstudio.getdailydiamondguide.Tasks;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.elevenappstudio.getdailydiamondguide.Modal.AllAppsInfo;
import java.util.ArrayList;
import java.util.List;

public class AllAppsInfoPreferencesManager {
    private static final String ALL_APPS_INFO_KEY = "allAppsInfoList";
    private static final String PREFS_NAME = "AllAppsInfoPrefs";

    public static void saveAllAppsList(Context context, List<AllAppsInfo> list) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFS_NAME, 0).edit();
        String json = new Gson().toJson((Object) list);
        edit.remove(ALL_APPS_INFO_KEY);
        edit.putString(ALL_APPS_INFO_KEY, json).apply();
    }

    public static List<AllAppsInfo> loadAllAppsList(Context context) {
        String string = context.getSharedPreferences(PREFS_NAME, 0).getString(ALL_APPS_INFO_KEY, (String) null);
        if (string == null) {
            return new ArrayList();
        }
        return (List) new Gson().fromJson(string, new TypeToken<List<AllAppsInfo>>() {
        }.getType());
    }
}
