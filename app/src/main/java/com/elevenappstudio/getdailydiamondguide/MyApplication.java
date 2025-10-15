package com.elevenappstudio.getdailydiamondguide;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.multidex.MultiDex;

import com.google.firebase.FirebaseApp;

public class MyApplication extends Application {

    public static SharedPreferences sharedPreferencesInApp;
    public static SharedPreferences.Editor editorInApp;

    public static String MoreApps = "More+Apps";
    public static String PrivacyPolicy = "https://www.freeprivacypolicy.com/blog/privacy-policy-url/";

    public static int checkInAppUpdate = 0; // 0==FLEXIBLE &&  1==IMMEDIATE

    public static Context context1;

    public static int getuser_balance() {
        return sharedPreferencesInApp.getInt("user_balance", 0);
    }

    public static void setuser_balance(int balance) {
        editorInApp.putInt("user_balance", balance);
        editorInApp.apply();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Firebase
        FirebaseApp.initializeApp(this);
        
        sharedPreferencesInApp = getSharedPreferences("my", MODE_PRIVATE);
        editorInApp = sharedPreferencesInApp.edit();

        context1 = getApplicationContext();
        
        // Initialize Firebase URL Manager
        FirebaseUrlManager.getInstance();
    }

    @Override
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}


