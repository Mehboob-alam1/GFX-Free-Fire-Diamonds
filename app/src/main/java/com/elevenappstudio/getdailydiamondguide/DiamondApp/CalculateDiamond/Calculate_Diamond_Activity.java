package com.elevenappstudio.getdailydiamondguide.DiamondApp.CalculateDiamond;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;
import com.elevenappstudio.getdailydiamondguide.FirebaseUrlManager;
import com.elevenappstudio.getdailydiamondguide.AdWebViewActivity;

public class Calculate_Diamond_Activity extends AppCompatActivity {

    private static final int AD_REQUEST_CODE = 301;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculate_diamond);

        // Remove old ads - they are disabled
        // AdsClass.Show_Native_Ads(Calculate_Diamond_Activity.this, findViewById(R.id.lnr_ads));
        // AdsClass.Show_Banner_Ads(Calculate_Diamond_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.iv_basic_diamond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate("Basic Diamond");
                } else {
                    navigateTo("Basic Diamond");
                }
            }
        });

        findViewById(R.id.iv_normal_diamond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate("Normal Diamond");
                } else {
                    navigateTo("Normal Diamond");
                }
            }
        });


        findViewById(R.id.iv_advance_diamond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate("Advance Diamond");
                } else {
                    navigateTo("Advance Diamond");
                }
            }
        });

    }

    private void showAdThenNavigate(String diamondType) {
        String url = FirebaseUrlManager.getInstance().getAdUrl();
        Intent intent = new Intent(this, AdWebViewActivity.class);
        intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
        intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, 0);
        intent.putExtra("target_activity", Calculate_Now_Activity.class.getName());
        intent.putExtra("extra_name", diamondType);
        startActivityForResult(intent, AD_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AD_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String extraName = data.getStringExtra("extra_name");
            if (extraName != null) {
                navigateTo(extraName);
            }
        }
    }

    private void navigateTo(String diamondType) {
        Intent intent = new Intent(this, Calculate_Now_Activity.class);
        intent.putExtra("name", diamondType);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // Remove old back ad - just finish
        finish();
    }

}