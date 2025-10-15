package com.elevenappstudio.getdailydiamondguide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.elevenappstudio.getdailydiamondguide.Modal.CleanAppsInfo;
import com.elevenappstudio.getdailydiamondguide.databinding.ItemCleanAppsBinding;
import java.util.List;

public class CleanAppsAdapter extends RecyclerView.Adapter<CleanAppsAdapter.AppViewHolder> {
    private List<CleanAppsInfo> appList;
    private Context context;

    public CleanAppsAdapter(Context context2, List<CleanAppsInfo> list) {
        this.context = context2;
        this.appList = list;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AppViewHolder(ItemCleanAppsBinding.inflate(LayoutInflater.from(this.context), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(AppViewHolder appViewHolder, int i) {
        CleanAppsInfo cleanAppsInfo = this.appList.get(i);
        appViewHolder.binding.appName.setText(cleanAppsInfo.appName);
        appViewHolder.binding.appPkgName.setText(cleanAppsInfo.pkgName);
        appViewHolder.binding.appIcon.setImageDrawable(cleanAppsInfo.appIcon);
        appViewHolder.binding.appCleanCacheSize.setText(cleanAppsInfo.formatCacheSize);
    }

    @Override
    public int getItemCount() {
        return this.appList.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder {
        ItemCleanAppsBinding binding;

        public AppViewHolder(ItemCleanAppsBinding itemCleanAppsBinding) {
            super(itemCleanAppsBinding.getRoot());
            this.binding = itemCleanAppsBinding;
        }
    }
}
