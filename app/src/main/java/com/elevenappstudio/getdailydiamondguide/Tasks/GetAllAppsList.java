package com.elevenappstudio.getdailydiamondguide.Tasks;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.transition.TransitionManager;
import com.google.android.material.transition.MaterialFadeThrough;
import com.elevenappstudio.getdailydiamondguide.Adapter.DashboardAppsAdapter;
import com.elevenappstudio.getdailydiamondguide.Constants;
import com.elevenappstudio.getdailydiamondguide.Modal.AllAppsInfo;
import com.elevenappstudio.getdailydiamondguide.Modal.DashboardAppsInfo;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentHomeBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class GetAllAppsList {
    public static DashboardAppsAdapter dashboardAppsAdapter;
    Context context;
    FragmentHomeBinding fragmentHomeBinding;
    private FragmentManager fragmentManager;

    public GetAllAppsList(Context context2, FragmentManager fragmentManager2, FragmentHomeBinding fragmentHomeBinding2) {
        this.context = context2;
        this.fragmentManager = fragmentManager2;
        this.fragmentHomeBinding = fragmentHomeBinding2;
        dashboardAppsAdapter = new DashboardAppsAdapter(context2, fragmentManager2, Constants.dashboardAppsInfoMap, Constants.dashboardAppsPkgNamesList);
        fragmentHomeBinding2.gameListRCV.setAdapter(dashboardAppsAdapter);
        fetchAllInstalledApps();
    }

    private void fetchAllInstalledApps() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                call1(new Handler(Looper.getMainLooper()));
            }
        });

    }

    public void call1(Handler handler) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                call2(getAllInstalledApps(context));
            }
        });
    }


    public void call2(List list) {
        Constants.allAppsInfoList = list;
        dashboardAppsAdapter.notifyDataSetChanged();
        TransitionManager.beginDelayedTransition((ViewGroup) this.fragmentHomeBinding.getRoot(), new MaterialFadeThrough());
        this.fragmentHomeBinding.dashboardShimmer.setVisibility(View.GONE);
        this.fragmentHomeBinding.gameListRCV.setVisibility(View.VISIBLE);
    }

    private List<AllAppsInfo> getAllInstalledApps(Context context2) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context2.getPackageManager();
        for (ApplicationInfo next : packageManager.getInstalledApplications(128)) {
            boolean z = true;
            if ((next.flags & 1) == 0) {
                if (next.category != 0) {
                    z = false;
                }
                arrayList.add(new AllAppsInfo(packageManager.getApplicationLabel(next).toString(), next.packageName, packageManager.getApplicationIcon(next), z));
                if (z) {
                    DashboardAppsInfo dashboardAppsInfo = new DashboardAppsInfo(packageManager.getApplicationLabel(next).toString(), next.packageName, packageManager.getApplicationIcon(next));
                    Constants.dashboardAppsPkgNamesList.add(next.packageName);
                    Constants.dashboardAppsInfoMap.put(next.packageName, dashboardAppsInfo);
                }
            }
        }
        return Constants.allAppsInfoList.size() == arrayList.size() ? Constants.allAppsInfoList : arrayList;
    }

    public static void updateData() {
        dashboardAppsAdapter.updateData(Constants.dashboardAppsInfoMap);
    }
}
