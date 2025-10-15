package com.elevenappstudio.getdailydiamondguide.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.elevenappstudio.getdailydiamondguide.Fragments.Boost;
import com.elevenappstudio.getdailydiamondguide.Fragments.Home;
import com.elevenappstudio.getdailydiamondguide.Modal.AllAppsInfo;
import com.elevenappstudio.getdailydiamondguide.databinding.ItemAllUserAppsBinding;
import java.util.ArrayList;
import java.util.List;

public class AddedGamesAdapter extends RecyclerView.Adapter<AddedGamesAdapter.AppViewHolder> {
    public static List<AllAppsInfo> appList;

    private Context context;
    private FragmentManager fragmentManager;

    public AddedGamesAdapter(Context context2, FragmentManager fragmentManager2, List<AllAppsInfo> list) {
        this.context = context2;
        this.fragmentManager = fragmentManager2;
        appList = list;
    }

    public void updateList(List<AllAppsInfo> list) {
        appList = list;
        notifyDataSetChanged();
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AppViewHolder(ItemAllUserAppsBinding.inflate(LayoutInflater.from(this.context), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(AppViewHolder appViewHolder, int i) {
        AllAppsInfo allAppsInfo = appList.get(i);
        appViewHolder.binding.appName.setText(allAppsInfo.appName);
        appViewHolder.binding.appIcon.setImageDrawable(allAppsInfo.appIcon);
        appViewHolder.binding.addedAppsBoostMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addedAppCall(allAppsInfo, v);
            }
        });

    }


    public void addedAppCall(AllAppsInfo allAppsInfo, View view) {
        view.performHapticFeedback(1, 2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(allAppsInfo.appName);
        arrayList.add(allAppsInfo.pkgName);
        String json = new Gson().toJson((Object) arrayList);
        Boost boost = new Boost();
        Bundle bundle = new Bundle();
        bundle.putString("appDetailsList", json);
        boost.setArguments(bundle);
        boost.show(this.fragmentManager, "FullScreenBottomSheetFragment");
        Home.bottomSheetFragment.dismiss();
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public static class AppViewHolder extends RecyclerView.ViewHolder {
        ItemAllUserAppsBinding binding;

        public AppViewHolder(ItemAllUserAppsBinding itemAllUserAppsBinding) {
            super(itemAllUserAppsBinding.getRoot());
            this.binding = itemAllUserAppsBinding;
        }
    }
}
