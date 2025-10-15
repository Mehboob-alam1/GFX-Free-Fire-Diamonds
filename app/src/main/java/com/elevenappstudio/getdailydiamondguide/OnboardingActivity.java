package com.elevenappstudio.getdailydiamondguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity implements OnboardingAdapter.OnboardingClickListener {

    private ViewPager2 viewPager;
    private LinearLayout dotsIndicator;
    private OnboardingAdapter adapter;
    private List<OnboardingItem> onboardingItems;
    private ImageView[] dots;
    private int currentPage = 0;
    
    private static final int AD_REQUEST_CODE = 100;
    private static final String ONBOARDING_URL = "https://easyranktools.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        initViews();
        setupOnboardingItems();
        setupViewPager();
        setupDotsIndicator();
    }

    private void initViews() {
        viewPager = findViewById(R.id.onboardingViewPager);
        dotsIndicator = findViewById(R.id.dotsIndicator);
    }

    private void setupOnboardingItems() {
        onboardingItems = new ArrayList<>();
        
        FirebaseUrlManager urlManager = FirebaseUrlManager.getInstance();
        String adUrl = urlManager.getAdUrl();
        
        // Page 1
        onboardingItems.add(new OnboardingItem(
            R.drawable.logo,
            "Boost Your Gaming",
            "Experience ultra-smooth gameplay with our advanced optimization tools",
            adUrl
        ));
        
        // Page 2
        onboardingItems.add(new OnboardingItem(
            R.drawable.logo,
            "Clean & Speed Up",
            "Remove junk files and free up space for better performance",
            adUrl
        ));
        
        // Page 3
        onboardingItems.add(new OnboardingItem(
            R.drawable.logo,
            "Game Mode Ready",
            "Optimize your device for the ultimate gaming experience",
            adUrl
        ));
        
        // Page 4
        onboardingItems.add(new OnboardingItem(
            R.drawable.logo,
            "Performance Optimizer",
            "Maximize FPS and minimize lag for the best gaming experience",
            adUrl
        ));
        
        // Page 5
        onboardingItems.add(new OnboardingItem(
            R.drawable.logo,
            "Let's Get Started!",
            "You're all set! Start boosting your games now",
            adUrl
        ));
    }

    private void setupViewPager() {
        adapter = new OnboardingAdapter(onboardingItems, this);
        viewPager.setAdapter(adapter);
        
        // Disable swiping - user can only navigate via button
        viewPager.setUserInputEnabled(false);
        
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPage = position;
                updateDotsIndicator(position);
            }
        });
    }

    private void setupDotsIndicator() {
        dots = new ImageView[onboardingItems.size()];
        dotsIndicator.removeAllViews();
        
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background));
            
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 0, 8, 0);
            params.width = 25;
            params.height = 25;
            
            dotsIndicator.addView(dots[i], params);
        }
        
        updateDotsIndicator(0);
    }

    private void updateDotsIndicator(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[i].setColorFilter(Color.parseColor("#000000"));
            } else {
                dots[i].setColorFilter(Color.parseColor("#CCCCCC"));
            }
        }
    }

    @Override
    public void onNextClicked(int position, String url) {
        // Check if ads should be shown
        if (FirebaseUrlManager.getInstance().shouldShowAds()) {
            // Open WebView with the URL
            Intent intent = new Intent(OnboardingActivity.this, AdWebViewActivity.class);
            intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
            intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, position + 1);
            startActivityForResult(intent, AD_REQUEST_CODE);
        } else {
            // Skip ad, go directly to next page or survey
            if (currentPage < onboardingItems.size() - 1) {
                viewPager.setCurrentItem(currentPage + 1);
            } else {
                goToSurvey();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == AD_REQUEST_CODE) {
            // User closed the ad
            if (currentPage < onboardingItems.size() - 1) {
                // Move to next onboarding page
                viewPager.setCurrentItem(currentPage + 1);
            } else {
                // Last page, go to Survey screens
                goToSurvey();
            }
        }
    }

    private void goToSurvey() {
        // Check if surveys should be shown
        if (FirebaseUrlManager.getInstance().shouldShowSurvey()) {
            Intent intent = new Intent(OnboardingActivity.this, SurveyActivity1.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else {
            // Skip surveys, go directly to main app
            Intent intent = new Intent(OnboardingActivity.this, MainTabsActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    @Override
    public void onBackPressed() {
        // Prevent back button during onboarding
        // User must complete onboarding
    }
}

