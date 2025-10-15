package com.elevenappstudio.getdailydiamondguide.DiamondApp.RareEmotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;

public class Level_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        AdsClass.Show_Native_Ads(Level_Activity.this, findViewById(R.id.lnr_ads));
        AdsClass.Show_Banner_Ads(Level_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.iv_0_25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Level_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Level_Activity.this, Emotes_Claim_Activity.class);
                        intent.putExtra("name", getIntent().getStringExtra("name"));
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_26_40).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Level_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Level_Activity.this, Emotes_Claim_Activity.class);
                        intent.putExtra("name", getIntent().getStringExtra("name"));
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_41_50).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Level_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Level_Activity.this, Emotes_Claim_Activity.class);
                        intent.putExtra("name", getIntent().getStringExtra("name"));
                        startActivity(intent);
                    }
                });
            }
        });
        findViewById(R.id.iv_51_60).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Level_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Level_Activity.this, Emotes_Claim_Activity.class);
                        intent.putExtra("name", getIntent().getStringExtra("name"));
                        startActivity(intent);
                    }
                });
            }
        });
        findViewById(R.id.iv_61).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Level_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Level_Activity.this, Emotes_Claim_Activity.class);
                        intent.putExtra("name", getIntent().getStringExtra("name"));
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