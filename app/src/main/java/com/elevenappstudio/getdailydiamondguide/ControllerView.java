package com.elevenappstudio.getdailydiamondguide;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.elevenappstudio.getdailydiamondguide.Fragments.Analytics;
import com.elevenappstudio.getdailydiamondguide.Fragments.Home;
import com.elevenappstudio.getdailydiamondguide.Fragments.Settings;
import com.elevenappstudio.getdailydiamondguide.Utils.RamUtils;
import com.elevenappstudio.getdailydiamondguide.Utils.StorageUtils;
import com.elevenappstudio.getdailydiamondguide.databinding.ActivityControllerViewBinding;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class ControllerView extends AppCompatActivity {
    ActivityControllerViewBinding binding;
    Context context;
    RamUtils ramUtils;
    StorageUtils storageUtils;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityControllerViewBinding inflate = ActivityControllerViewBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new ControllerViewOnApplyWindowInsetsListener());
        getWindow().setStatusBarColor(getColor(R.color.statusBarBackground));
        init();

    }

    static WindowInsetsCompat Call1(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    private void init() {
        this.context = this;
        this.ramUtils = new RamUtils(this.context);
        this.storageUtils = new StorageUtils(this.context);
        setNavigation();
        setDetails();
    }


    private void setNavigation() {
        this.binding.viewPager.setAdapter(new FragmentStateAdapter(getSupportFragmentManager(), getLifecycle()) {
            @Override
            public int getItemCount() {
                return 3;
            }

            @Override
            public Fragment createFragment(int i) {
                if (i == 1) {
                    return new Analytics();
                }
                if (i != 2) {
                    return new Home();
                }
                return new Settings();
            }
        });
        this.binding.viewPager.setOffscreenPageLimit(3);
        this.binding.bottomNavigationView.setItemSelected(R.id.frag_home, true);
        this.binding.bottomNavigationView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                binding.viewPager.setCurrentItem(getViewPagerPosition(i), true);
            }
        });

        this.binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int i) {
                ControllerView.this.binding.bottomNavigationView.setItemSelected(ControllerView.this.getMenuItemId(i), true);
            }
        });
    }

    public void setDetails() {
        this.binding.ramUsagePercentTxt.setText(this.ramUtils.getPercentUsedString());
        this.binding.ramUsedTxt.setText(this.ramUtils.getUsedMemory());
        this.binding.totalRamTxt.setText(this.ramUtils.getTotalMemory());
        this.binding.ramUsageProgressBar.setProgress(this.ramUtils.getPercentUsed());
        this.binding.storageUsagePercentTxt.setText(this.storageUtils.getPercentUsedString());
        this.binding.storageUsedTxt.setText(this.storageUtils.getUsedStorage());
        this.binding.totalStorageTxt.setText(this.storageUtils.getTotalStorage());
        this.binding.storageUsageProgressBar.setProgress(this.storageUtils.getPercentUsed());
    }

    
    public int getMenuItemId(int i) {
        if (i == 1) {
            return R.id.frag_analytics;
        }
        if (i != 2) {
            return R.id.frag_home;
        }
        return R.id.frag_settings;
    }

    private int getViewPagerPosition(int i) {
        if (i == R.id.frag_home) {
            return 0;
        }
        if (i == R.id.frag_analytics) {
            return 1;
        }
        if (i == R.id.frag_settings) {
            return 2;
        }
        return 0;
    }

    @Override
    public void onBackPressed() {
        ExitDialog();
    }

    private void ExitDialog() {

        final Dialog dialog = new Dialog(ControllerView.this, R.style.DialogTheme);
        dialog.setContentView(R.layout.popup_exit_dialog);
        dialog.setCancelable(false);

        RelativeLayout no = (RelativeLayout) dialog.findViewById(R.id.no);
        RelativeLayout rate = (RelativeLayout) dialog.findViewById(R.id.rate);
        RelativeLayout yes = (RelativeLayout) dialog.findViewById(R.id.yes);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String rateapp = getPackageName();
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + rateapp));
                startActivity(intent1);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
                System.exit(0);
            }
        });

        dialog.show();
    }
}


