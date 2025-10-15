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
import com.elevenappstudio.getdailydiamondguide.FirebaseUrlManager;
import com.elevenappstudio.getdailydiamondguide.AdWebViewActivity;

public class Rare_Emotes_Activity extends AppCompatActivity {

    private static final int AD_REQUEST_CODE = 302;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rare_emotes);

        // Remove old ads - they are disabled
        // AdsClass.Show_Native_Ads(Rare_Emotes_Activity.this, findViewById(R.id.lnr_ads));
        // AdsClass.Show_Banner_Ads(Rare_Emotes_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Setup emote buttons with Firebase ads
        setupEmoteButton(R.id.iv_emote_1, Map_Activity.class, null);
        setupEmoteButton(R.id.iv_emote_2, Emotes_Activity.class, "Emote 1");
        setupEmoteButton(R.id.iv_emote_3, Emotes_Activity.class, "Emote 2");
        setupEmoteButton(R.id.iv_emote_4, Emotes_Activity.class, "Emote 3");
        setupEmoteButton(R.id.iv_emote_5, Emotes_Activity.class, "Emote 4");
        setupEmoteButton(R.id.iv_emote_6, Emotes_Activity.class, "Emote 5");
        setupEmoteButton(R.id.iv_emote_7, Emotes_Activity.class, "Emote 6");
        setupEmoteButton(R.id.iv_emote_8, Emotes_Activity.class, "Emote 7");
        setupEmoteButton(R.id.iv_emote_9, Emotes_Activity.class, "Emote 8");
        setupEmoteButton(R.id.iv_emote_10, Emotes_Activity.class, "Emote 9");
        setupEmoteButton(R.id.iv_emote_11, Emotes_Activity.class, "Emote 10");
        setupEmoteButton(R.id.iv_emote_12, Emotes_Activity.class, "Emote 11");
        setupEmoteButton(R.id.iv_emote_13, Emotes_Activity.class, "Emote 12");
        setupEmoteButton(R.id.iv_emote_14, Emotes_Activity.class, "Emote 13");
        setupEmoteButton(R.id.iv_emote_15, Emotes_Activity.class, "Emote 14");
        setupEmoteButton(R.id.iv_emote_16, Emotes_Activity.class, "Emote 15");

    }

    private void setupEmoteButton(int buttonId, Class<?> targetActivity, String extraName) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(targetActivity, extraName);
                } else {
                    navigateTo(targetActivity, extraName);
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

    @Override
    public void onBackPressed() {
        // Remove old back ad - just finish
        finish();
    }
}