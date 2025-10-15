package com.elevenappstudio.getdailydiamondguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdWebViewActivity extends AppCompatActivity {

    private WebView adWebView;
    private FloatingActionButton closeButton;
    private TextView timerText;
    private ProgressBar loadingProgress;
    private boolean canClose = false;
    private CountDownTimer countDownTimer;

    public static final String EXTRA_URL = "extra_url";
    public static final String EXTRA_SURVEY_NUMBER = "extra_survey_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_webview);

        initViews();
        setupWebView();
        loadUrl();
        startTimer();
    }

    private void initViews() {
        adWebView = findViewById(R.id.adWebView);
        closeButton = findViewById(R.id.closeButton);
        timerText = findViewById(R.id.timerText);
        loadingProgress = findViewById(R.id.loadingProgress);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canClose) {
                    returnResultAndFinish();
                }
            }
        });
    }

    private void setupWebView() {
        WebSettings webSettings = adWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setDefaultTextEncodingName("utf-8");

        // WebViewClient to handle page loading
        adWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingProgress.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // WebChromeClient for progress
        adWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    loadingProgress.setVisibility(View.GONE);
                } else {
                    loadingProgress.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void loadUrl() {
        String url = getIntent().getStringExtra(EXTRA_URL);
        if (url != null && !url.isEmpty()) {
            adWebView.loadUrl(url);
        } else {
            Toast.makeText(this, "No URL provided", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void startTimer() {
        canClose = false;
        closeButton.setVisibility(View.GONE);

        countDownTimer = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                timerText.setText("Please wait " + secondsRemaining + "s");
            }

            @Override
            public void onFinish() {
                canClose = true;
                timerText.setText("You can close now");
                closeButton.setVisibility(View.VISIBLE);
            }
        };
        countDownTimer.start();
    }

    @Override
    public void onBackPressed() {
        if (canClose) {
            returnResultAndFinish();
        } else {
            Toast.makeText(this, "Please wait 15 seconds to close", Toast.LENGTH_SHORT).show();
        }
    }

    private void returnResultAndFinish() {
        // Return the data that was passed to this activity
        Intent resultIntent = new Intent();
        String targetActivity = getIntent().getStringExtra("target_activity");
        String extraName = getIntent().getStringExtra("extra_name");
        
        if (targetActivity != null) {
            resultIntent.putExtra("target_activity", targetActivity);
        }
        if (extraName != null) {
            resultIntent.putExtra("extra_name", extraName);
        }
        
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (adWebView != null) {
            adWebView.destroy();
        }
    }
}


