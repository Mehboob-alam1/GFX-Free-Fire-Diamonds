package com.elevenappstudio.getdailydiamondguide.Bottomsheets;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.transition.MaterialFadeThrough;
import com.elevenappstudio.getdailydiamondguide.Adapter.AddedGamesAdapter;
import com.elevenappstudio.getdailydiamondguide.Constants;
import com.elevenappstudio.getdailydiamondguide.Modal.AllAppsInfo;
import com.elevenappstudio.getdailydiamondguide.Tasks.GetAddedGames;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentAddGamesBinding;
import java.util.ArrayList;

public class AddGames extends BottomSheetDialogFragment {
    FragmentAddGamesBinding binding;
    Context context;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentAddGamesBinding inflate = FragmentAddGamesBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        init();
    }

    private void init() {
        this.binding.usersAppsListRCV.setLayoutManager(new LinearLayoutManager(this.context, RecyclerView.VERTICAL, false));
        new GetAddedGames(this.context, this.binding, new AddedGamesAdapter(this.context, getParentFragmentManager(), Constants.allAppsInfoList)).execute(new Void[0]);
        this.binding.searchAppsEditText.requestFocus();
        this.binding.searchAppsEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AddGames.this.searchApps(charSequence.toString());
            }
        });
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    
    public void searchApps(String str) {
        ArrayList arrayList = new ArrayList();
        for (AllAppsInfo next : Constants.allAppsInfoList) {
            if (next.appName.toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
        }
        this.binding.usersAppsListRCV.setHasFixedSize(false);
        GetAddedGames.adapter.updateList(arrayList);
        TransitionManager.beginDelayedTransition((ViewGroup) this.binding.getRoot(), new MaterialFadeThrough());
        this.binding.usersAppsListRCV.setVisibility(View.VISIBLE);
        this.binding.usersAppsListRCV.setItemViewCacheSize(arrayList.size());
        this.binding.usersAppsListRCV.setAdapter(GetAddedGames.adapter);
    }

}
