package com.elevenappstudio.getdailydiamondguide.Fragments;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.elevenappstudio.getdailydiamondguide.R;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentBoostBinding;
import java.util.List;
import java.util.Random;

public class Boost extends BottomSheetDialogFragment {
    
    public List<String> appDetailsList;
    FragmentBoostBinding binding;
    Context context;
    
    public int currentIndex = 0;
    int randomInt;
    
    public String[] textArray = {"Cleaning up...", "Hold tight...", "Just a moment...", "Halfway done...", "Finishing touches...", "Looking good...", "Ready to Launch!"};

    @Override
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogTheme);
        if (!(getArguments() == null || (string = getArguments().getString("appDetailsList")) == null)) {
            this.appDetailsList = (List) new Gson().fromJson(string, new TypeToken<List<String>>() {
            }.getType());
        }
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentBoostBinding inflate = FragmentBoostBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        getRandomInt();
        startTextAnimation();
        startDigitAnimation(0, 100);
        this.binding.boostProgress.setPrefix("");
        this.binding.boostProgress.setSuffix("%");
        this.binding.boostProgress.setDecimalFormat("#");
        this.binding.appName.setText(this.appDetailsList.get(0));
        this.binding.launchAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                Boost.this.context.startActivity(Boost.this.context.getPackageManager().getLaunchIntentForPackage((String) Boost.this.appDetailsList.get(1)));
                Boost.this.dismiss();
            }
        });
        try {
            PackageManager packageManager = requireContext().getPackageManager();
            this.binding.appIcon.setImageDrawable(packageManager.getApplicationIcon(packageManager.getApplicationInfo(this.appDetailsList.get(1), 0)));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            this.binding.appIcon.setImageResource(R.drawable.soft_bolt);
        }
    }

    private void startDigitAnimation(int i, int i2) {
        this.binding.boostProgress.setStart(i);
        this.binding.boostProgress.setEnd(i2);
        this.binding.boostProgress.animateToValue((long) this.randomInt);
    }

    private void startTextAnimation() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.context, 17432577);
        int i = this.randomInt;
        String[] strArr = this.textArray;
        loadAnimation.setDuration((long) ((i / strArr.length) / strArr.length));
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this.context, 17432576);
        int i2 = this.randomInt;
        String[] strArr2 = this.textArray;
        loadAnimation2.setDuration((long) ((i2 / strArr2.length) / strArr2.length));
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (Boost.this.currentIndex == Boost.this.textArray.length - 1) {
                    TransitionManager.beginDelayedTransition((ViewGroup) Boost.this.binding.getRoot(), new Slide());
                    Boost.this.binding.launchAppBtn.setVisibility(View.VISIBLE);
                    Boost.this.setCancelable(true);
                    return;
                }
                Boost boost = Boost.this;
                int unused = boost.currentIndex = (boost.currentIndex + 1) % Boost.this.textArray.length;
                Boost.this.binding.boostProgressText.setText(Boost.this.textArray[Boost.this.currentIndex]);
                Boost.this.binding.boostProgressText.startAnimation(loadAnimation2);
            }
        });
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Boost.this.binding.boostProgressText.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Boost.this.binding.boostProgressText.startAnimation(loadAnimation);
                    }
                }, (long) (Boost.this.randomInt / Boost.this.textArray.length));
            }
        });
        this.binding.boostProgressText.startAnimation(loadAnimation);
    }

    private void getRandomInt() {
        int length = this.textArray.length * 1000;
        this.randomInt = new Random().nextInt(15001 - length) + length;
    }
}


