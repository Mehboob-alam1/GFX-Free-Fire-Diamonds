package com.elevenappstudio.getdailydiamondguide.Fragments;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.elevenappstudio.getdailydiamondguide.Utils.BatteryUtils;
import com.elevenappstudio.getdailydiamondguide.Utils.CPUFreq;
import com.elevenappstudio.getdailydiamondguide.Utils.CPUUtils;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentAnalyticsBinding;
import java.util.List;

public class Analytics extends Fragment implements BatteryUtils.BatteryUpdateListener, CPUUtils.CpuUpdateListener, CPUFreq.CPUUsageCallback {
    BatteryUtils batteryUtils;
    FragmentAnalyticsBinding binding;
    Context context;
    private CPUFreq cpuFreq;
    CPUUtils cpuUtils;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentAnalyticsBinding inflate = FragmentAnalyticsBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        getBatteryDetails();
        getCPUDetails();
    }

    
    public void getBatteryDetails() {
        BatteryUtils batteryUtils2 = new BatteryUtils(this.context);
        this.batteryUtils = batteryUtils2;
        batteryUtils2.addBatteryUpdateListener(this);
        this.binding.batHealthTxt.setText(this.batteryUtils.getBatteryHealth());
    }

    
    public void getCPUDetails() {
        this.cpuUtils = new CPUUtils(this.context);
        this.cpuFreq = new CPUFreq(this);
        this.cpuUtils.addCpuUpdateListener(this);
        if (this.cpuUtils.getCpuCoreCount() > 10) {
            this.binding.cpuCoresTxt.setText(this.cpuUtils.getCpuCoreCount() + " Cores");
        } else {
            this.binding.cpuCoresTxt.setText("0" + this.cpuUtils.getCpuCoreCount() + " Cores");
        }
        this.binding.cpuFreqTxt.setText(this.cpuUtils.getOverallCpuFrequencies());
    }

    @Override
    public void onBatteryUpdate(String str, String str2, String str3, int i, int i2, int i3) {
        this.binding.batTimeLeftTxt.setText(str2);
        this.binding.chargingStatusTxt.setText(str);
        this.binding.batPowerTxt.setText(str3);
        this.binding.batVoltageTxt.setText(i2 + " mv");
        this.binding.batTempTxt.setText(i3 + "°C");
        this.binding.batLevelTxt.setText(i + "%");
        this.binding.batLevelProgressBar.setProgress(i);
        this.binding.batLevelPBTxt.setText(i + "%");
        this.binding.batTempBigTxt.setText(i3 + "°C");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.batteryUtils.removeBatteryUpdateListener(this);
        this.batteryUtils.cleanup();
        this.cpuUtils.removeCpuUpdateListener(this);
        this.cpuUtils.cleanup();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.cpuFreq.startMonitoring();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.cpuFreq.stopMonitoring();
    }

    @Override
    public void onCpuUpdate(int i, int i2) {
        this.binding.cpuTempBigTxt.setText(i2 + "°C");
    }

    @Override
    public void onUsageUpdate(int i, List<Double> list) {
        this.binding.cpuUsagePBTxt.setText(i + "%");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.binding.cpuUsageProgressBar, "progress", new int[]{i});
        ofInt.setDuration(200);
        ofInt.start();
    }
}


