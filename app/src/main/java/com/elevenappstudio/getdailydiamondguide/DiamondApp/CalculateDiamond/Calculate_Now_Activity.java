package com.elevenappstudio.getdailydiamondguide.DiamondApp.CalculateDiamond;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.R;

public class Calculate_Now_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_now);

        AdsClass.Show_Native_Ads(Calculate_Now_Activity.this, findViewById(R.id.lnr_ads));
        AdsClass.Show_Banner_Ads(Calculate_Now_Activity.this, findViewById(R.id.lnr_banner_ads),"Small");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        EditText et_diamond = (EditText) findViewById(R.id.et_diamond);
        TextView tv_dollars = (TextView) findViewById(R.id.tv_dollars);
        RelativeLayout rlt_calculate_now = (RelativeLayout) findViewById(R.id.rlt_calculate_now);

        if (getIntent().getStringExtra("name").equals("Basic Diamond")) {

            rlt_calculate_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!et_diamond.getText().toString().isEmpty()) {
                        Double value1 = Double.parseDouble(et_diamond.getText().toString());
                        Double parseDouble = Double.parseDouble("71");

                        Double calculatedValue = value1 * parseDouble;
                        tv_dollars.setText(calculatedValue.toString() + " Dollars.");
                    }
                }
            });

        } else if (getIntent().getStringExtra("name").equals("Normal Diamond")) {

            rlt_calculate_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!et_diamond.getText().toString().isEmpty()) {
                        Double value1 = Double.parseDouble(et_diamond.getText().toString());
                        Double parseDouble = Double.parseDouble("0.00625");

                        Double calculatedValue = value1 * parseDouble;
                        tv_dollars.setText(calculatedValue.toString() + " Dollars.");
                    }
                }
            });

        } else if (getIntent().getStringExtra("name").equals("Advance Diamond")) {

            rlt_calculate_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!et_diamond.getText().toString().isEmpty()) {
                        Double value1 = Double.parseDouble(et_diamond.getText().toString());
                        Double parseDouble = Double.parseDouble("62");

                        Double calculatedValue = value1 * parseDouble;
                        tv_dollars.setText(calculatedValue.toString() + " Dollars.");
                    }
                }
            });

        }

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