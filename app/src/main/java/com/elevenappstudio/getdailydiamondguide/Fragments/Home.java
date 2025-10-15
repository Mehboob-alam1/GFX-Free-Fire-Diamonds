package com.elevenappstudio.getdailydiamondguide.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.elevenappstudio.getdailydiamondguide.AdWebViewActivity;
import com.elevenappstudio.getdailydiamondguide.Bottomsheets.AddGames;
import com.elevenappstudio.getdailydiamondguide.Bottomsheets.AskPermissionBS;
import com.elevenappstudio.getdailydiamondguide.Bottomsheets.Cleanable;
import com.elevenappstudio.getdailydiamondguide.Constants;
import com.elevenappstudio.getdailydiamondguide.FirebaseUrlManager;
import com.elevenappstudio.getdailydiamondguide.R;
import com.elevenappstudio.getdailydiamondguide.Tasks.AllAppsInfoPreferencesManager;
import com.elevenappstudio.getdailydiamondguide.Tasks.DashboardAppsPreferencesManager;
import com.elevenappstudio.getdailydiamondguide.Tasks.GetAllAppsList;
import com.elevenappstudio.getdailydiamondguide.Utils.PermissionUtils;
import com.elevenappstudio.getdailydiamondguide.Utils.TinyDB;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentHomeBinding;
import java.time.Instant;

public class Home extends Fragment {
    public static FragmentHomeBinding binding = null;
    public static AddGames bottomSheetFragment = null;
    public static Cleanable cleanableBottomSheet = null;
    public static boolean isCleanBtnEnabled = true;
    Context context;
    TinyDB tinyDB;
    
    private static final int AD_REQUEST_CODE_ADD_GAME = 101;
    private static final int AD_REQUEST_CODE_CLEANUP = 102;
    private String pendingAction = null; // "add_game" or "cleanup"

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static Home newInstance(String str, String str2) {
        return new Home();
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentHomeBinding inflate = FragmentHomeBinding.inflate(layoutInflater, viewGroup, false);
        binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        init();
    }

    
    public void init() {
        this.context = getContext();
        initAppsListing();
        this.tinyDB = new TinyDB(this.context);
        binding.addGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                
                // Check if ads should be shown
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    pendingAction = "add_game";
                    showAd(AD_REQUEST_CODE_ADD_GAME);
                } else {
                    // No ad, open directly
                    openAddGames();
                }
            }
        });
        binding.cleanUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                
                // Check if ads should be shown
                if (FirebaseUrlManager.getInstance().shouldShowAds()) {
                    pendingAction = "cleanup";
                    showAd(AD_REQUEST_CODE_CLEANUP);
                } else {
                    // No ad, execute directly
                    performCleanupAction();
                }
            }
        });
    }


    public void initAppsListing() {
        Constants.allAppsInfoList = AllAppsInfoPreferencesManager.loadAllAppsList(this.context);
        DashboardAppsPreferencesManager dashboardAppsPreferencesManager = new DashboardAppsPreferencesManager(this.context);
        Constants.dashboardAppsInfoMap = dashboardAppsPreferencesManager.loadDashboardApps(this.context);
        Constants.dashboardAppsPkgNamesList = dashboardAppsPreferencesManager.loadDashboardAppsPkgName();
        new GetAllAppsList(this.context, getChildFragmentManager(), binding);
        binding.gameListRCV.setLayoutManager(new GridLayoutManager(this.context, 2, RecyclerView.VERTICAL, false));
        binding.gameListRCV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 > 0) {
                    Home.binding.addGameButton.hide();
                    Home.binding.cleanUpButton.hide();
                } else if (i2 < 0) {
                    Home.binding.addGameButton.show();
                    Home.binding.cleanUpButton.show();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showAd(int requestCode) {
        String url = FirebaseUrlManager.getInstance().getAdUrl();
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.putExtra(AdWebViewActivity.EXTRA_URL, url);
        intent.putExtra(AdWebViewActivity.EXTRA_SURVEY_NUMBER, 0);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == AD_REQUEST_CODE_ADD_GAME) {
            // User closed ad, now open Add Games
            openAddGames();
        } else if (requestCode == AD_REQUEST_CODE_CLEANUP) {
            // User closed ad, now perform cleanup action
            performCleanupAction();
        }
    }

    private void openAddGames() {
        Home.bottomSheetFragment = new AddGames();
        Home.bottomSheetFragment.show(Home.this.getChildFragmentManager(), Home.bottomSheetFragment.getTag());
    }

    private void performCleanupAction() {
        if (!PermissionUtils.hasUsageStatsPermission(Home.this.context)) {
            AskPermissionBS.newInstance(R.drawable.usage_permission, "Usage Permission", "This app needs access to your apps for usage and statistics. Please grant permission to continue.").show(Home.this.getChildFragmentManager(), "PermissionBottomSheet");
        } else if (!Home.isCleanBtnEnabled) {
            Toast.makeText(Home.this.context, "Device is Cleaned Already!", Toast.LENGTH_SHORT).show();
        } else {
            Home.cleanableBottomSheet = new Cleanable();
            Home.cleanableBottomSheet.show(Home.this.getChildFragmentManager(), "FullScreenBottomSheet");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        long epochSecond = Instant.now().getEpochSecond();
        if (!PermissionUtils.hasUsageStatsPermission(this.context)) {
            binding.cleanUpButton.setSubtitle("Permission Required");
        } else if (this.tinyDB.getLong(Constants.LAST_DEVICE_CLEANED_TIME) > epochSecond) {
            binding.cleanUpButton.setSubtitle("Device Cleaned!");
            isCleanBtnEnabled = false;
        } else {
            binding.cleanUpButton.setSubtitle("Tap to clean");
            isCleanBtnEnabled = true;
        }
    }
}


