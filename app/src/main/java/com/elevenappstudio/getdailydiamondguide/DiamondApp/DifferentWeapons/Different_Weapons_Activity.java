package com.elevenappstudio.getdailydiamondguide.DiamondApp.DifferentWeapons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide.Diamonds_Guide_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.SportVehicles.Sport_Vehicles_Activity;

public class Different_Weapons_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_weapons);

        AdsClass.Show_Native_Ads(Different_Weapons_Activity.this, findViewById(R.id.lnr_ads));
        AdsClass.Show_Banner_Ads(Different_Weapons_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.iv_mk_12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Different_Weapons_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Different_Weapons_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Mk12");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_scarl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Different_Weapons_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Different_Weapons_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Scarl");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_akm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Different_Weapons_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Different_Weapons_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "AKM");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_grozny).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Different_Weapons_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Different_Weapons_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Grozny");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_crossbow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Different_Weapons_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Different_Weapons_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "Crossbow");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_qbz95).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Different_Weapons_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Different_Weapons_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "QBZ95");
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_auga3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Different_Weapons_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Different_Weapons_Activity.this, Diamonds_Guide_Activity.class);
                        intent.putExtra("name", "AUG A3");
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