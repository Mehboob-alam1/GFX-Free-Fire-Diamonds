package com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass;

import android.app.Activity;
import android.widget.LinearLayout;

import com.elevenappstudio.getdailydiamondguide.R;

public class AdsClass {

    public interface AdsClick {
        void AdsDismiss(boolean b);
    }

    // Removed AdMob implementation - just call callback directly
    public static void Show_Interstitial_Ads(Activity activity, AdsClick adsClick) {
        // No ads - directly execute callback
        if (adsClick != null) {
            adsClick.AdsDismiss(true);
        }
    }

    public static void Show_Back_Interstitial_Ads(Activity activity, AdsClick adsClick) {
        // No ads - directly execute callback
        if (adsClick != null) {
            adsClick.AdsDismiss(true);
        }
    }

    public static void Show_Native_Ads(Activity activity, LinearLayout linearLayout) {
        // No ads - hide the container
        if (linearLayout != null) {
            linearLayout.setVisibility(android.view.View.GONE);
        }
    }

    public static void Show_Banner_Ads(Activity activity, LinearLayout linearLayout, String Type) {
        // No ads - hide the container
        if (linearLayout != null) {
            linearLayout.setVisibility(android.view.View.GONE);
        }
    }
}
