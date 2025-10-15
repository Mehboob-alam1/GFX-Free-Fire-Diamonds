package com.elevenappstudio.getdailydiamondguide;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DarkModeSwitch extends FrameLayout {
    private ImageView backgroundView;
    private FloatingActionButton fab;
    private boolean isDarkMode = false;

    public DarkModeSwitch(Context context) {
        super(context);
        init(context);
    }

    public DarkModeSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        ImageView imageView = new ImageView(context);
        this.backgroundView = imageView;
        imageView.setBackgroundColor(-1);
        addView(this.backgroundView, new LayoutParams(-1, -1));
        FloatingActionButton floatingActionButton = new FloatingActionButton(context);
        this.fab = floatingActionButton;
        floatingActionButton.setImageResource(17301563);
        this.fab.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, 17170432)));
        addView(this.fab, new LayoutParams(-2, -2));
        this.fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDarkMode();
            }
        });

    }


    private void toggleDarkMode() {
        int i = 1;
        this.isDarkMode = !this.isDarkMode;
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.backgroundView, this.fab.getWidth() / 2, this.fab.getHeight() / 2, 0.0f, (float) Math.hypot((double) getWidth(), (double) getHeight()));
        if (this.isDarkMode) {
            this.backgroundView.setBackgroundColor(-16777216);
            this.fab.setImageResource(17301577);
            this.fab.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), 17170443)));
        } else {
            this.backgroundView.setBackgroundColor(-1);
            this.fab.setImageResource(17301563);
            this.fab.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), 17170432)));
        }
        createCircularReveal.start();
        if (this.isDarkMode) {
            i = 2;
        }
        AppCompatDelegate.setDefaultNightMode(i);
    }
}


