package com.elevenappstudio.getdailydiamondguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivity5 extends AppCompatActivity {

    private TextView surveyTitle, surveyQuestion;
    private RadioGroup surveyOptions;
    private RadioButton option1, option2, option3, option4;
    private Button submitButton;
    
    private static final int AD_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        initViews();
        setupSurveyContent();
        setupListeners();
    }

    private void initViews() {
        surveyTitle = findViewById(R.id.surveyTitle);
        surveyQuestion = findViewById(R.id.surveyQuestion);
        surveyOptions = findViewById(R.id.surveyOptions);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        submitButton = findViewById(R.id.submitButton);
    }

    private void setupSurveyContent() {
        // Set survey 5 content - You can replace these
        surveyTitle.setText("Survey 5 of 5");
        surveyQuestion.setText("Would you recommend this app to friends?");
        option1.setText("Definitely Yes");
        option2.setText("Probably Yes");
        option3.setText("Maybe");
        option4.setText("Not Sure");
    }

    private void setupListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = surveyOptions.getCheckedRadioButtonId();
                
                if (selectedId == -1) {
                    Toast.makeText(SurveyActivity5.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get selected answer
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedAnswer = selectedRadioButton.getText().toString();
                
                // You can log or save the answer here if needed
                // Log.d("Survey5", "Selected: " + selectedAnswer);

                // Open Ad WebView
                openAdWebView();
            }
        });
    }

    private void openAdWebView() {
        // Check if ads should be shown
        if (FirebaseUrlManager.getInstance().shouldShowAds()) {
            String url = FirebaseUrlManager.getInstance().getAdUrl();
            Intent intent = new Intent(SurveyActivity5.this, AdWebViewActivity.class);
            intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
            intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, 5);
            startActivityForResult(intent, AD_REQUEST_CODE);
        } else {
            // Skip ad, go directly to main app
            goToMainApp();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AD_REQUEST_CODE) {
            // User closed the ad, go to main app
            goToMainApp();
        }
    }

    private void goToMainApp() {
        Intent intent = new Intent(SurveyActivity5.this, MainTabsActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        // Prevent back button during survey
        Toast.makeText(this, "Please complete the survey", Toast.LENGTH_SHORT).show();
    }
}

