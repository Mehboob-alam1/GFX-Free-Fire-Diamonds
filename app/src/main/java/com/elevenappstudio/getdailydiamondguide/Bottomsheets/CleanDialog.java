package com.elevenappstudio.getdailydiamondguide.Bottomsheets;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.transition.MaterialElevationScale;
import com.elevenappstudio.getdailydiamondguide.Constants;
import com.elevenappstudio.getdailydiamondguide.Fragments.Home;
import com.elevenappstudio.getdailydiamondguide.Modal.CleanAppsInfo;
import com.elevenappstudio.getdailydiamondguide.R;
import com.elevenappstudio.getdailydiamondguide.Utils.TinyDB;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentCleanDialogBinding;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class CleanDialog extends BottomSheetDialogFragment {
    
    public List<CleanAppsInfo> allAppsInfoList = Constants.allCleanAppList;
    FragmentCleanDialogBinding binding;
    Context context;
    
    public int currentIndex = 0;
    int randomInt;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentCleanDialogBinding inflate = FragmentCleanDialogBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        getRandomInt();
        startTextAnimation();
        startDigitAnimation(0, 99);
        this.binding.boostProgressText.setPrefix("");
        this.binding.boostProgressText.setSuffix("%");
        this.binding.boostProgressText.setDecimalFormat("#");
        this.binding.dismissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                CleanDialog.this.dismiss();
            }
        });
    }

    private void startDigitAnimation(int i, int i2) {
        this.binding.boostProgressText.setStart(i);
        this.binding.boostProgressText.setEnd(i2);
        this.binding.boostProgressText.animateToValue((long) this.randomInt);
    }

    private void startTextAnimation() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.context, 17432577);
        loadAnimation.setDuration((long) ((this.randomInt / this.allAppsInfoList.size()) / this.allAppsInfoList.size()));
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this.context, 17432576);
        loadAnimation2.setDuration((long) ((this.randomInt / this.allAppsInfoList.size()) / this.allAppsInfoList.size()));
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (CleanDialog.this.currentIndex == CleanDialog.this.allAppsInfoList.size() - 1) {
                    CleanDialog.this.binding.boostProgressText.setText("100%");
                    TransitionManager.beginDelayedTransition((ViewGroup) CleanDialog.this.binding.getRoot(), new MaterialElevationScale(true));
                    CleanDialog.this.binding.lottieAnimationView.setAnimation(R.raw.circle_boost);
                    CleanDialog.this.binding.imageView.setVisibility(View.VISIBLE);
                    CleanDialog.this.binding.appNamesTextView.setText("Your Phone Boosted Now!");
                    TransitionManager.beginDelayedTransition((ViewGroup) CleanDialog.this.binding.getRoot(), new Slide());
                    CleanDialog.this.binding.dismissBtn.setVisibility(View.VISIBLE);
                    CleanDialog.this.binding.boostProgressText.setText(Constants.CLEANABLE_CACHE + " Cleaned!");
                    CleanDialog.this.binding.boostProgressText.setTextSize(20.0f);
                    Home.isCleanBtnEnabled = false;
                    new TinyDB(CleanDialog.this.context).putLong(Constants.LAST_DEVICE_CLEANED_TIME, Instant.now().getEpochSecond() + 600);
                    Home.binding.cleanUpButton.setSubtitle("Device Cleaned!");
                    return;
                }
                CleanDialog cleanDialog = CleanDialog.this;
                int unused = cleanDialog.currentIndex = (cleanDialog.currentIndex + 1) % CleanDialog.this.allAppsInfoList.size();
                CleanDialog.this.binding.appNamesTextView.setText(((CleanAppsInfo) CleanDialog.this.allAppsInfoList.get(CleanDialog.this.currentIndex)).appName + "... (" + ((CleanAppsInfo) CleanDialog.this.allAppsInfoList.get(CleanDialog.this.currentIndex)).formatCacheSize + ")");
                CleanDialog.this.binding.appNamesTextView.startAnimation(loadAnimation2);
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
                CleanDialog.this.binding.appNamesTextView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CleanDialog.this.binding.appNamesTextView.startAnimation(loadAnimation);
                    }
                }, (long) (CleanDialog.this.randomInt / CleanDialog.this.allAppsInfoList.size()));
            }
        });
        this.binding.appNamesTextView.startAnimation(loadAnimation);
    }

    private void getRandomInt() {
        int size = (this.allAppsInfoList.size() / 2) * 1000;
        this.randomInt = new Random().nextInt(((size + 1000) - size) + 1) + size;
    }
}
