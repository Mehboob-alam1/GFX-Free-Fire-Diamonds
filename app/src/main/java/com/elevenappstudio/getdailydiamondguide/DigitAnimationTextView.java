package com.elevenappstudio.getdailydiamondguide;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import java.text.DecimalFormat;

public class DigitAnimationTextView extends AppCompatTextView {
    
    public DecimalFormat decimalFormat;
    private float endValue = 100.0f;
    
    public String prefix = "";
    
    public float startValue = 0.0f;
    
    public String suffix = "";

    public DigitAnimationTextView(Context context) {
        super(context);
        init();
    }

    public DigitAnimationTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.decimalFormat = new DecimalFormat("#,##0");
    }

    public void setStart(int i) {
        this.startValue = (float) i;
    }

    public void setEnd(int i) {
        this.endValue = (float) i;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setDecimalFormat(String str) {
        this.decimalFormat = new DecimalFormat(str);
    }

    public void animateToValue(long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.startValue, this.endValue});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = DigitAnimationTextView.this.startValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                DigitAnimationTextView.this.setText(DigitAnimationTextView.this.prefix + DigitAnimationTextView.this.decimalFormat.format((double) DigitAnimationTextView.this.startValue) + DigitAnimationTextView.this.suffix);
            }
        });
        ofFloat.start();
    }

    public float getCurrentValue() {
        return this.startValue;
    }
}


