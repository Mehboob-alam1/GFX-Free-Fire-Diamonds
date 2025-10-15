package com.elevenappstudio.getdailydiamondguide.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.elevenappstudio.getdailydiamondguide.Bottomsheets.GFXSettings;
import com.elevenappstudio.getdailydiamondguide.Fragments.Boost;
import com.elevenappstudio.getdailydiamondguide.Modal.DashboardAppsInfo;
import com.elevenappstudio.getdailydiamondguide.databinding.ItemGameAppsBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DashboardAppsAdapter extends RecyclerView.Adapter<DashboardAppsAdapter.AppViewHolder> {
    private Context context;
    private Map<String, DashboardAppsInfo> dashboardAppsInfoMap;
    private List<String> dashboardAppsPkgNamesList;
    
    public FragmentManager fragmentManager;

    public DashboardAppsAdapter(Context context2, FragmentManager fragmentManager2, Map<String, DashboardAppsInfo> map, List<String> list) {
        this.context = context2;
        this.fragmentManager = fragmentManager2;
        this.dashboardAppsInfoMap = map;
        this.dashboardAppsPkgNamesList = list;
    }

    public void updateData(Map<String, DashboardAppsInfo> map) {
        this.dashboardAppsInfoMap = map;
        this.dashboardAppsPkgNamesList = new ArrayList(map.keySet());
        notifyDataSetChanged();
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AppViewHolder(ItemGameAppsBinding.inflate(LayoutInflater.from(this.context), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(AppViewHolder appViewHolder, int i) {
        String str = this.dashboardAppsPkgNamesList.get(i);
        final DashboardAppsInfo dashboardAppsInfo = this.dashboardAppsInfoMap.get(str);
        appViewHolder.binding.appName.setText(dashboardAppsInfo.appName);
        appViewHolder.binding.appIcon.setImageDrawable(dashboardAppsInfo.appIcon);
        appViewHolder.binding.appBoostMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appBoostCall(str, dashboardAppsInfo, v);
            }
        });

        appViewHolder.binding.gfxsettingsMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                GFXSettings gFXSettings = new GFXSettings();
                Bundle bundle = new Bundle();
                bundle.putString("gamePkg", dashboardAppsInfo.pkgName);
                gFXSettings.setArguments(bundle);
                gFXSettings.show(DashboardAppsAdapter.this.fragmentManager, "FullScreenBottomSheetFragment");
            }
        });
    }

    public void appBoostCall(String str, DashboardAppsInfo dashboardAppsInfo, View view) {
        view.performHapticFeedback(1, 2);
        if (this.context.getPackageManager().getLaunchIntentForPackage(str) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(dashboardAppsInfo.appName);
            arrayList.add(dashboardAppsInfo.pkgName);
            String json = new Gson().toJson((Object) arrayList);
            Boost boost = new Boost();
            Bundle bundle = new Bundle();
            bundle.putString("appDetailsList", json);
            boost.setArguments(bundle);
            boost.show(this.fragmentManager, "FullScreenBottomSheetFragment");
        }
    }

    @Override
    public int getItemCount() {
        return this.dashboardAppsPkgNamesList.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder {
        ItemGameAppsBinding binding;

        public AppViewHolder(ItemGameAppsBinding itemGameAppsBinding) {
            super(itemGameAppsBinding.getRoot());
            this.binding = itemGameAppsBinding;
        }
    }
}
