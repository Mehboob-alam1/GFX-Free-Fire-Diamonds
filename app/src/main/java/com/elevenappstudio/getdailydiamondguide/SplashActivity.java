package com.elevenappstudio.getdailydiamondguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize user balance
        MyApplication.setuser_balance(0);

        // Navigate after delay - give Firebase time to load config (3 seconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if survey/onboarding should be shown
                boolean shouldShow = FirebaseUrlManager.getInstance().shouldShowSurvey();
                Log.d(TAG, "shouldShowSurvey = " + shouldShow);
                Toast.makeText(SplashActivity.this, "showSurvey = " + shouldShow, Toast.LENGTH_LONG).show();
                
                if (shouldShow) {
                    // Show onboarding
                    Log.d(TAG, "Going to OnboardingActivity");
                    Intent i = new Intent(SplashActivity.this, OnboardingActivity.class);
                    startActivity(i);
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                } else {
                    // Skip onboarding and surveys, go directly to main app
                    Log.d(TAG, "Skipping to MainTabsActivity");
                    Intent i = new Intent(SplashActivity.this, MainTabsActivity.class);
                    startActivity(i);
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        }, 3000);
    }
}

