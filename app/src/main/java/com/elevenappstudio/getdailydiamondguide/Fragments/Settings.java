package com.elevenappstudio.getdailydiamondguide.Fragments;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;

import com.elevenappstudio.getdailydiamondguide.Services.NotificationService;
import com.elevenappstudio.getdailydiamondguide.MyApplication;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentSettingsBinding;

public class Settings extends Fragment {
    FragmentSettingsBinding binding;
    Context context;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentSettingsBinding inflate = FragmentSettingsBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        this.binding.notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Intent intent = new Intent(Settings.this.context, NotificationService.class);
                if (z) {
                    Settings.this.context.startForegroundService(intent);
                    return;
                }
                intent.setAction("STOP_SERVICE");
                Settings.this.context.startService(intent);
            }
        });
        this.binding.moreAppLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //more app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=" + MyApplication.MoreApps));
                startActivity(intent);
            }
        });
        this.binding.rateAppLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate app
                final String rateapp = getActivity().getPackageName();
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + rateapp));
                startActivity(intent1);
            }
        });
        this.binding.privacyAppLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //privacy policy
                Intent intentPrivacy = new Intent(Intent.ACTION_VIEW, Uri.parse(MyApplication.PrivacyPolicy));
                intentPrivacy.setPackage("com.android.chrome");
                startActivity(intentPrivacy);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        this.binding.notificationSwitch.setChecked(isServiceRunning(NotificationService.class));
    }

    private boolean isServiceRunning(Class<?> cls) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) this.context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (cls.getName().equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}


