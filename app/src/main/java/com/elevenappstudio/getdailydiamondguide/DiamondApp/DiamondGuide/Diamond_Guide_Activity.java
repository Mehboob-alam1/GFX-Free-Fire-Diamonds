package com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.DifferentWeapons.Different_Weapons_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.Earn_Diamonds_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.ManCharacter.Man_Character_Activity;
import com.elevenappstudio.getdailydiamondguide.R;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.SportVehicles.Sport_Vehicles_Activity;
import com.elevenappstudio.getdailydiamondguide.FirebaseUrlManager;
import com.elevenappstudio.getdailydiamondguide.AdWebViewActivity;

public class Diamond_Guide_Activity extends AppCompatActivity {

    private static final int AD_REQUEST_CODE = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_guide);

        // Remove old ads - they are disabled
        // AdsClass.Show_Native_Ads(Diamond_Guide_Activity.this, findViewById(R.id.lnr_ads));
        // AdsClass.Show_Banner_Ads(Diamond_Guide_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_diamonds_guide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Diamonds_Guide_Activity.class, "Diamond Guide");
                } else {
                    navigateTo(Diamonds_Guide_Activity.class, "Diamond Guide");
                }
            }
        });

        findViewById(R.id.iv_tips_and_tricks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Diamonds_Guide_Activity.class, "Tips & Tricks");
                } else {
                    navigateTo(Diamonds_Guide_Activity.class, "Tips & Tricks");
                }
            }
        });

        findViewById(R.id.iv_sport_vehicles).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Sport_Vehicles_Activity.class, null);
                } else {
                    navigateTo(Sport_Vehicles_Activity.class, null);
                }
            }
        });

        findViewById(R.id.iv_different_weapons).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Different_Weapons_Activity.class, null);
                } else {
                    navigateTo(Different_Weapons_Activity.class, null);
                }
            }
        });

        findViewById(R.id.iv_man_character).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Man_Character_Activity.class, null);
                } else {
                    navigateTo(Man_Character_Activity.class, null);
                }
            }
        });

    }

    private void showAdThenNavigate(Class<?> targetActivity, String extraName) {
        String url = FirebaseUrlManager.getInstance().getAdUrl();
        Intent intent = new Intent(this, AdWebViewActivity.class);
        intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
        intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, 0);
        intent.putExtra("target_activity", targetActivity.getName());
        if (extraName != null) {
            intent.putExtra("extra_name", extraName);
        }
        startActivityForResult(intent, AD_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AD_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String targetClassName = data.getStringExtra("target_activity");
            String extraName = data.getStringExtra("extra_name");
            if (targetClassName != null) {
                try {
                    Class<?> targetClass = Class.forName(targetClassName);
                    navigateTo(targetClass, extraName);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void navigateTo(Class<?> activityClass, String extraName) {
        Intent intent = new Intent(this, activityClass);
        if (extraName != null) {
            intent.putExtra("name", extraName);
        }
        startActivity(intent);
    }
}