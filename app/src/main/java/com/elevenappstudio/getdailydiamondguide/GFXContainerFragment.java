package com.elevenappstudio.getdailydiamondguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class GFXContainerFragment extends Fragment {

    ActivityControllerViewBinding binding;
    RamUtils ramUtils;
    StorageUtils storageUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the GFX Tool layout
        binding = ActivityControllerViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        this.ramUtils = new RamUtils(requireContext());
        this.storageUtils = new StorageUtils(requireContext());
        setNavigation();
        setDetails();
    }

    private void setNavigation() {
        this.binding.viewPager.setAdapter(new FragmentStateAdapter(getChildFragmentManager(), getLifecycle()) {
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
                GFXContainerFragment.this.binding.bottomNavigationView.setItemSelected(GFXContainerFragment.this.getMenuItemId(i), true);
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
}

