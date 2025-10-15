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

public class SurveyActivity4 extends AppCompatActivity {

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
        // Set survey 4 content - You can replace these
        surveyTitle.setText("Survey 4 of 5");
        surveyQuestion.setText("What device do you primarily use for gaming?");
        option1.setText("Flagship Device (High-end)");
        option2.setText("Mid-range Device");
        option3.setText("Budget Device");
        option4.setText("Tablet");
    }

    private void setupListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = surveyOptions.getCheckedRadioButtonId();
                
                if (selectedId == -1) {
                    Toast.makeText(SurveyActivity4.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get selected answer
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedAnswer = selectedRadioButton.getText().toString();
                
                // You can log or save the answer here if needed
                // Log.d("Survey4", "Selected: " + selectedAnswer);

                // Open Ad WebView
                openAdWebView();
            }
        });
    }

    private void openAdWebView() {
        // Check if ads should be shown
        if (FirebaseUrlManager.getInstance().shouldShowAds()) {
            String url = FirebaseUrlManager.getInstance().getAdUrl();
            Intent intent = new Intent(SurveyActivity4.this, AdWebViewActivity.class);
            intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
            intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, 4);
            startActivityForResult(intent, AD_REQUEST_CODE);
        } else {
            // Skip ad, go directly to next survey
            goToNextSurvey();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AD_REQUEST_CODE) {
            // User closed the ad, go to next survey
            goToNextSurvey();
        }
    }

    private void goToNextSurvey() {
        Intent intent = new Intent(SurveyActivity4.this, SurveyActivity5.class);
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

