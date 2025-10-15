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

public class Emotes_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotes);

        AdsClass.Show_Native_Ads(Emotes_Activity.this, findViewById(R.id.lnr_ads));
        AdsClass.Show_Banner_Ads(Emotes_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.iv_prop_player).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Emotes_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Emotes_Activity.this, Level_Activity.class);
                        intent.putExtra("name", getIntent().getStringExtra("name"));
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_max_player).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Emotes_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Emotes_Activity.this, Level_Activity.class);
                        intent.putExtra("name", getIntent().getStringExtra("name"));
                        startActivity(intent);
                    }
                });
            }
        });

        findViewById(R.id.iv_casual_player).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsClass.Show_Interstitial_Ads(Emotes_Activity.this, new AdsClass.AdsClick() {
                    @Override
                    public void AdsDismiss(boolean b) {
                        Intent intent = new Intent(Emotes_Activity.this, Level_Activity.class);
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