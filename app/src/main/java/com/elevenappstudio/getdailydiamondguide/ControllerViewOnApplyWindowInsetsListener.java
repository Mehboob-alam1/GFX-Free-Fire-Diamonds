package com.elevenappstudio.getdailydiamondguide;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;


public final class ControllerViewOnApplyWindowInsetsListener implements OnApplyWindowInsetsListener {

    @Override
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return ControllerView.Call1(view, windowInsetsCompat);
    }
}


