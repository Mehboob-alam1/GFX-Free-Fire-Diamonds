package com.elevenappstudio.getdailydiamondguide.Bottomsheets;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.elevenappstudio.getdailydiamondguide.AdWebViewActivity;
import com.elevenappstudio.getdailydiamondguide.Adapter.PrimaryItemAdapter;
import com.elevenappstudio.getdailydiamondguide.Adapter.SpinnerItems;
import com.elevenappstudio.getdailydiamondguide.FirebaseUrlManager;
import com.elevenappstudio.getdailydiamondguide.Modal.PrimaryItems;
import com.elevenappstudio.getdailydiamondguide.Utils.ShizukuPermission;
import com.elevenappstudio.getdailydiamondguide.Utils.WaitingDialog;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentGfxSettingsBinding;
import eightbitlab.com.blurview.RenderScriptBlur;
import java.util.ArrayList;
import rikka.shizuku.Shizuku;

public class GFXSettings extends BottomSheetDialogFragment {
    public static int detail_int;
    public static int fps_int;
    public static String graphicsSpinner;
    public static int resolution_int;
    public static int shadow_int;
    public static int sound_int;
    public static int styles_int;
    public static int water_int;
    FragmentGfxSettingsBinding binding;
    Context context;
    String gamePkg;
    PrimaryItemAdapter primaryItemAdapter;
    WaitingDialog waitingDialog;
    
    private static final int AD_REQUEST_CODE_LAUNCH = 103;

    @Override
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        if (getArguments() != null && (string = getArguments().getString("gamePkg")) != null) {
            this.gamePkg = string;
        }
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentGfxSettingsBinding inflate = FragmentGfxSettingsBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        this.waitingDialog = new WaitingDialog(this.context);
        this.binding.gfxItemRCV.setLayoutManager(new LinearLayoutManager(this.context, RecyclerView.VERTICAL, false));
        ArrayList<PrimaryItems> primaryItems = getPrimaryItems();
        PrimaryItemAdapter primaryItemAdapter2 = new PrimaryItemAdapter(this.context, primaryItems);
        this.primaryItemAdapter = primaryItemAdapter2;
        primaryItemAdapter2.setHasStableIds(false);
        this.binding.gfxItemRCV.setAdapter(this.primaryItemAdapter);
        this.binding.gfxItemRCV.setItemViewCacheSize(primaryItems.size());
        this.binding.blurView.setupWith((ViewGroup) requireActivity().getWindow().getDecorView(), new RenderScriptBlur(requireContext())).setFrameClearDrawable(requireActivity().getWindow().getDecorView().getBackground()).setBlurRadius(20.0f).setBlurEnabled(true);
        this.binding.applySettingsAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                if (Build.VERSION.SDK_INT >= 34) {
                    String[] strArr = SpinnerItems.skipGames;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        if (!strArr[i].equals(GFXSettings.this.gamePkg)) {
                            i++;
                        } else if (!Shizuku.pingBinder()) {
                            ShizukuPermissionBS.Show(GFXSettings.this.context);
                            return;
                        } else if (ShizukuPermission.isShizukuGranted()) {
                            GFXSettings.this.applyFiles();
                            return;
                        } else {
                            return;
                        }
                    }
                    GFXSettings.this.applyFiles();
                    return;
                }
                GFXSettings.this.applyFiles();
            }
        });
    }

    
    public void applyFiles() {
        if (this.binding.applySettingsAppBtnText.getText().equals("APPLY SETTINGS")) {
            this.waitingDialog.show();
            new CountDownTimer(3000, 1000) {
                @Override
                public void onTick(long j) {
                }

                @Override
                public void onFinish() {
                    GFXSettings.this.waitingDialog.dismiss();
                    GFXSettings.this.binding.applySettingsAppBtnText.setText("LAUNCH GAME");
                }
            }.start();
            return;
        }
        
        // Button text is "LAUNCH GAME" - check if ad should be shown
        if (FirebaseUrlManager.getInstance().shouldShowAds()) {
            // Show ad before launching game
            showAdBeforeLaunch();
        } else {
            // No ad, launch game directly
            launchGame();
        }
    }
    
    private void showAdBeforeLaunch() {
        String url = FirebaseUrlManager.getInstance().getAdUrl();
        Intent intent = new Intent(requireActivity(), AdWebViewActivity.class);
        intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
        intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, 0);
        startActivityForResult(intent, AD_REQUEST_CODE_LAUNCH);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == AD_REQUEST_CODE_LAUNCH) {
            // User closed ad, now launch game
            launchGame();
        }
    }
    
    private void launchGame() {
        this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage(this.gamePkg));
        dismiss();
    }

    private ArrayList<PrimaryItems> getPrimaryItems() {
        ArrayList<PrimaryItems> arrayList = new ArrayList<>();
        String[] strArr = SpinnerItems.skipGames;
        int length = strArr.length;
        int i = 0;
        while (true) {
            String str = "Select your game effect quality, lower is better";
            String str2 = "Effect Quality";
            if (i < length) {
                int i2 = length;
                String[] strArr2 = strArr;
                int i3 = i;
                if (strArr[i].equals(this.gamePkg)) {
                    arrayList.add(new PrimaryItems("Resolution", "Select your game resolution, lower is better", SpinnerItems.resolution, 0));
                    arrayList.add(new PrimaryItems("Frame Rate", "Select your game frame rate, lower is better", SpinnerItems.fps, 0));
                    arrayList.add(new PrimaryItems("Graphics Quality", "Select your game graphics quality, lower is better", SpinnerItems.graphics, 0));
                    arrayList.add(new PrimaryItems("Styles", "Select your game style quality, lower is better", SpinnerItems.styles, 0));
                    arrayList.add(new PrimaryItems("Sound Quality", "Select your game sound quality, lower is better", SpinnerItems.sound, 0));
                    arrayList.add(new PrimaryItems("Water Quality", "Select your game water quality, lower is better", SpinnerItems.water, 0));
                    arrayList.add(new PrimaryItems("Shadows", "Select your game shadows quality, lower is better", SpinnerItems.shadow, 0));
                    arrayList.add(new PrimaryItems("Details", "Select your game details quality, lower is better", SpinnerItems.detail, 0));
                    arrayList.add(new PrimaryItems("Anti-Aliasing", "Select your game anti-aliasing quality, lower is better", SpinnerItems.anti_aliasing, 0));
                    arrayList.add(new PrimaryItems("Render Quality", "Select your game render quality, lower is better", SpinnerItems.render, 0));
                    String str3 = "Texture Quality";
                    arrayList.add(new PrimaryItems(str3, "Select your game texture quality, lower is better", SpinnerItems.texture, 0));
                    String str4 = str2;
                    arrayList.add(new PrimaryItems(str4, str, SpinnerItems.effects, 0));
                    return arrayList;
                }
                i = i3 + 1;
                length = i2;
                strArr = strArr2;
            } else {
                String str5 = str;
                arrayList.add(new PrimaryItems("Frame Rate", "Select your game frame rate, lower is better", SpinnerItems.fps, 0));
                arrayList.add(new PrimaryItems("Sound Quality", "Select your game sound quality, lower is better", SpinnerItems.sound, 0));
                arrayList.add(new PrimaryItems("Details", "Select your game details quality, lower is better", SpinnerItems.detail, 0));
                arrayList.add(new PrimaryItems("Anti-Aliasing", "Select your game anti-aliasing quality, lower is better", SpinnerItems.anti_aliasing, 0));
                arrayList.add(new PrimaryItems("Render Quality", "Select your game render quality, lower is better", SpinnerItems.render, 0));
                arrayList.add(new PrimaryItems("Texture Quality", "Select your game texture quality, lower is better", SpinnerItems.texture, 0));
                String str6 = str2;
                arrayList.add(new PrimaryItems(str6, str, SpinnerItems.effects, 0));
                return arrayList;
            }
        }
    }
}
