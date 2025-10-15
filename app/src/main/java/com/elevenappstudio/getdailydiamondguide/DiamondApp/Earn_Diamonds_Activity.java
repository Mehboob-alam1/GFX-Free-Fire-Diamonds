package com.elevenappstudio.getdailydiamondguide.DiamondApp;

import com.elevenappstudio.getdailydiamondguide.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.CalculateDiamond.Calculate_Diamond_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide.Diamond_Guide_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.RareEmotes.Rare_Emotes_Activity;

public class Earn_Diamonds_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_diamonds);

        AdsClass.Show_Native_Ads(Earn_Diamonds_Activity.this, findViewById(R.id.lnr_ads));

        findViewById(R.id.iv_diamond_guide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Earn_Diamonds_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Earn_Diamonds_Activity.this, Diamond_Guide_Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_calculate_diamond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Earn_Diamonds_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Earn_Diamonds_Activity.this, Calculate_Diamond_Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_rare_emotes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Earn_Diamonds_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Earn_Diamonds_Activity.this, Rare_Emotes_Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}