package com.elevenappstudio.getdailydiamondguide.Tasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.elevenappstudio.getdailydiamondguide.Modal.DashboardAppsInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardAppsPreferencesManager {
    private static final String KEY_DASHBOARD_APPS = "dashboard_apps";
    private static final String KEY_DASHBOARD_APPS_PKG_NAMES = "dashboard_apps_pkg_names";
    private static final String PREF_NAME = "DashboardAppsPreferences";
    Context context;
    private final Gson gson = new Gson();
    private final SharedPreferences preferences;

    public DashboardAppsPreferencesManager(Context context2) {
        this.context = context2;
        this.preferences = context2.getSharedPreferences(PREF_NAME, 0);
    }

    public void saveDashboardApps(Map<String, DashboardAppsInfo> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put((String) next.getKey(), new SerializableDashboardAppsInfo((DashboardAppsInfo) next.getValue()));
        }
        String json = this.gson.toJson((Object) hashMap);
        this.preferences.edit().remove(KEY_DASHBOARD_APPS).apply();
        this.preferences.edit().putString(KEY_DASHBOARD_APPS, json).apply();
    }

    public void saveDashboardAppsPkgName(List<String> list) {
        String json = this.gson.toJson((Object) list);
        this.preferences.edit().remove(KEY_DASHBOARD_APPS_PKG_NAMES).apply();
        this.preferences.edit().putString(KEY_DASHBOARD_APPS_PKG_NAMES, json).apply();
    }

    public Map<String, DashboardAppsInfo> loadDashboardApps(Context context2) {
        String string = this.preferences.getString(KEY_DASHBOARD_APPS, (String) null);
        if (string == null) {
            return new HashMap();
        }
        Type type = new TypeToken<Map<String, SerializableDashboardAppsInfo>>() {
        }.getType();
        HashMap hashMap = new HashMap();
        for (Object entry : ((Map) this.gson.fromJson(string, type)).entrySet()) {
            hashMap.put((String) entry, ((SerializableDashboardAppsInfo) entry).toDashboardAppsInfo(context2));
        }
        return hashMap;
    }

    public List<String> loadDashboardAppsPkgName() {
        String string = this.preferences.getString(KEY_DASHBOARD_APPS_PKG_NAMES, (String) null);
        if (string == null) {
            return new ArrayList();
        }
        return (List) this.gson.fromJson(string, new TypeToken<List<String>>() {
        }.getType());
    }

    private static class SerializableDashboardAppsInfo {
        String appName;
        String pkgName;

        SerializableDashboardAppsInfo(DashboardAppsInfo dashboardAppsInfo) {
            this.appName = dashboardAppsInfo.appName;
            this.pkgName = dashboardAppsInfo.pkgName;
        }

        
        public DashboardAppsInfo toDashboardAppsInfo(Context context) {
            Drawable drawable;
            try {
                drawable = context.getPackageManager().getApplicationIcon(this.pkgName);
            } catch (Exception e) {
                e.printStackTrace();
                drawable = null;
            }
            return new DashboardAppsInfo(this.appName, this.pkgName, drawable);
        }
    }
}
