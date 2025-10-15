package com.elevenappstudio.getdailydiamondguide.Tasks;

import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Process;
import android.os.storage.StorageManager;
import android.view.View;
import android.view.ViewGroup;

import androidx.transition.TransitionManager;
import com.google.android.material.transition.MaterialFadeThrough;
import com.elevenappstudio.getdailydiamondguide.Adapter.CleanAppsAdapter;
import com.elevenappstudio.getdailydiamondguide.Constants;
import com.elevenappstudio.getdailydiamondguide.Modal.CleanAppsInfo;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentCleanableBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetCleanableApps extends AsyncTask<Void, Void, List<CleanAppsInfo>> {
    FragmentCleanableBinding binding;
    Context context;
    long totalCacheSize = 0;

    public GetCleanableApps(Context context2, FragmentCleanableBinding fragmentCleanableBinding) {
        this.context = context2;
        this.binding = fragmentCleanableBinding;
    }

    @Override
    public List<CleanAppsInfo> doInBackground(Void... voidArr) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.context.getPackageManager();
        for (ApplicationInfo next : packageManager.getInstalledApplications(128)) {
            if ((next.flags & 1) == 0) {
                String obj = packageManager.getApplicationLabel(next).toString();
                String str = next.packageName;
                Drawable loadIcon = next.loadIcon(packageManager);
                long cacheSize = getCacheSize(str);
                this.totalCacheSize += cacheSize;
                arrayList.add(new CleanAppsInfo(obj, str, loadIcon, cacheSize, formatSize(cacheSize)));
            }
        }
        Collections.sort(arrayList, new GetCleanableAppsComparator());
        return arrayList;
    }

    @Override
    public void onPostExecute(List<CleanAppsInfo> list) {
        Constants.allCleanAppList = list;
        this.binding.cleanAppsRCV.setAdapter(new CleanAppsAdapter(this.context, list));
        TransitionManager.beginDelayedTransition((ViewGroup) this.binding.getRoot(), new MaterialFadeThrough());
        this.binding.cleanableAppsShimmer.setVisibility(View.GONE);
        this.binding.cleanAppsRCV.setVisibility(View.VISIBLE);
        this.binding.cleanDashboard.setVisibility(View.VISIBLE);
        this.binding.cleanCacheSizeTxt.setText(formatSize(this.totalCacheSize));
        Constants.CLEANABLE_CACHE = formatSize(this.totalCacheSize);
    }

    private long getCacheSize(String str) {
        try {
            return ((StorageStatsManager) this.context.getSystemService("storagestats")).queryStatsForPackage(((StorageManager) this.context.getSystemService("storage")).getUuidForPath(this.context.getFilesDir()), str, Process.myUserHandle()).getCacheBytes();
        } catch (PackageManager.NameNotFoundException | IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private String formatSize(long j) {
        if (j <= 0) {
            return "0 B";
        }
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        double d = (double) j;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return String.format("%.1f %s", new Object[]{Double.valueOf(d / Math.pow(1024.0d, (double) log10)), strArr[log10]});
    }
}
