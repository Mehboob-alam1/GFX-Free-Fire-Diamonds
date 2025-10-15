package com.elevenappstudio.getdailydiamondguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.CalculateDiamond.Calculate_Diamond_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.DiamondGuide.Diamond_Guide_Activity;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.RareEmotes.Rare_Emotes_Activity;

public class DiamondContainerFragment extends Fragment {

    private static final int AD_REQUEST_CODE = 200;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Load the Diamond app main screen layout
        return inflater.inflate(R.layout.activity_earn_diamonds, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupDiamondApp(view);
    }

    private void setupDiamondApp(View view) {
        // Setup Diamond Guide button
        view.findViewById(R.id.iv_diamond_guide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if ads should be shown
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Diamond_Guide_Activity.class);
                } else {
                    navigateTo(Diamond_Guide_Activity.class);
                }
            }
        });

        // Setup Calculate Diamond button
        view.findViewById(R.id.iv_calculate_diamond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Calculate_Diamond_Activity.class);
                } else {
                    navigateTo(Calculate_Diamond_Activity.class);
                }
            }
        });

        // Setup Rare Emotes button
        view.findViewById(R.id.iv_rare_emotes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    showAdThenNavigate(Rare_Emotes_Activity.class);
                } else {
                    navigateTo(Rare_Emotes_Activity.class);
                }
            }
        });
    }

    private void showAdThenNavigate(Class<?> targetActivity) {
        String url = FirebaseUrlManager.getInstance().getAdUrl();
        Intent intent = new Intent(requireActivity(), AdWebViewActivity.class);
        intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
        intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, 0);
        intent.putExtra("target_activity", targetActivity.getName());
        startActivityForResult(intent, AD_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AD_REQUEST_CODE && resultCode == getActivity().RESULT_OK && data != null) {
            String targetClassName = data.getStringExtra("target_activity");
            if (targetClassName != null) {
                try {
                    Class<?> targetClass = Class.forName(targetClassName);
                    navigateTo(targetClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void navigateTo(Class<?> activityClass) {
        Intent intent = new Intent(requireActivity(), activityClass);
        startActivity(intent);
    }
}

