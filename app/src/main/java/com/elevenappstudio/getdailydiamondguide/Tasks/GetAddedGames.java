package com.elevenappstudio.getdailydiamondguide.Tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;

import androidx.transition.TransitionManager;
import com.google.android.material.transition.MaterialFadeThrough;
import com.elevenappstudio.getdailydiamondguide.Adapter.AddedGamesAdapter;
import com.elevenappstudio.getdailydiamondguide.Constants;
import com.elevenappstudio.getdailydiamondguide.Modal.AllAppsInfo;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentAddGamesBinding;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetAddedGames extends AsyncTask<Void, Void, List<AllAppsInfo>> {
    public static AddedGamesAdapter adapter;
    FragmentAddGamesBinding binding;
    Context context;

    public GetAddedGames(Context context2, FragmentAddGamesBinding fragmentAddGamesBinding, AddedGamesAdapter addedGamesAdapter) {
        this.context = context2;
        this.binding = fragmentAddGamesBinding;
        adapter = addedGamesAdapter;
    }

    @Override
    public List<AllAppsInfo> doInBackground(Void... voidArr) {
        Collections.sort(Constants.allAppsInfoList, new Comparator<AllAppsInfo>() {
            public int compare(AllAppsInfo allAppsInfo, AllAppsInfo allAppsInfo2) {
                if (allAppsInfo.isGame == allAppsInfo2.isGame) {
                    return 0;
                }
                return allAppsInfo.isGame ? -1 : 1;
            }
        });
        return Constants.allAppsInfoList;
    }

    @Override
    public void onPostExecute(List<AllAppsInfo> list) {
        this.binding.usersAppsListRCV.setHasFixedSize(true);
        this.binding.usersAppsListRCV.setAdapter(adapter);
        adapter.updateList(list);
        TransitionManager.beginDelayedTransition((ViewGroup) this.binding.getRoot(), new MaterialFadeThrough());
        this.binding.bottomsheetAppsShimmer.setVisibility(View.GONE);
        this.binding.usersAppsListRCV.setVisibility(View.VISIBLE);
    }
}
