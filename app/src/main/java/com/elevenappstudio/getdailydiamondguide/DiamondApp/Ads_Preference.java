package com.elevenappstudio.getdailydiamondguide.DiamondApp;

import java.util.ArrayList;

// Simplified - No AdMob preferences needed
public class Ads_Preference {

    public static boolean Get_Native_Show() {
        return false;
    }

    public static boolean Get_Banner_Show() {
        return false;
    }

    public static int Get_Native_Click() {
        return 0;
    }

    public static int Get_Banner_Click() {
        return 0;
    }

    public static String Get_Native_Link() {
        return "";
    }

    public static String Get_Banner_Link() {
        return "";
    }

    public static ArrayList<String> Get_Photo_Url_List() {
        return new ArrayList<>();
    }

    public static ArrayList<String> Get_Banner_Icon_List() {
        return new ArrayList<>();
    }
}
