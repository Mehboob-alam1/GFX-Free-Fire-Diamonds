package com.elevenappstudio.getdailydiamondguide.DiamondApp;

import com.elevenappstudio.getdailydiamondguide.R;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.CalculateDiamond.Calculate_Diamond_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AdsClass.Show_Interstitial_Ads(MainActivity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(MainActivity.this, OnBoarding_Activity.class);
                        startActivity(intent);
                    }
                });
            }
        },4000);



    }
}