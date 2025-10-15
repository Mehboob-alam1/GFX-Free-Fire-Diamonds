package com.elevenappstudio.getdailydiamondguide.DiamondApp.SportVehicles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide.Diamond_Guide_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide.Diamonds_Guide_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;

public class Sport_Vehicles_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_vehicles);

        AdsClass.Show_Native_Ads(Sport_Vehicles_Activity.this, findViewById(R.id.lnr_ads));
        AdsClass.Show_Banner_Ads(Sport_Vehicles_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        findViewById(R.id.iv_sport_car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Sport_Vehicles_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Sport_Vehicles_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name","Sport Car");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_sport_monstar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Sport_Vehicles_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Sport_Vehicles_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name","Monster");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_sport_moto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Sport_Vehicles_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Sport_Vehicles_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name","Moto");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_sport_amphibian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Sport_Vehicles_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Sport_Vehicles_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name","Amphibian");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_sport_military_jeep).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Sport_Vehicles_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Sport_Vehicles_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name","Military Jeep");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_sport_tuktuk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Sport_Vehicles_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Sport_Vehicles_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name","Tuk Tuk");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_sport_van).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Sport_Vehicles_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Sport_Vehicles_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name","Van");
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        AdsClass.Show_Back_Interstitial_Ads(this, new AdsClass.AdsClick() {
            @Override
            public void AdsDismiss(boolean b) {
                finish();
            }
        });
    }

}