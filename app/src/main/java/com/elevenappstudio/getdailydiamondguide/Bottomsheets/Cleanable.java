package com.elevenappstudio.getdailydiamondguide.Bottomsheets;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.elevenappstudio.getdailydiamondguide.Fragments.Home;
import com.elevenappstudio.getdailydiamondguide.Tasks.GetCleanableApps;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentCleanableBinding;

public class Cleanable extends BottomSheetDialogFragment {
    FragmentCleanableBinding binding;
    Context context;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentCleanableBinding inflate = FragmentCleanableBinding.inflate(layoutInflater, viewGroup, false);
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
        this.binding.cleanAppsRCV.setLayoutManager(new LinearLayoutManager(this.context, RecyclerView.VERTICAL, false));
        new GetCleanableApps(this.context, this.binding).execute(new Void[0]);
        this.binding.cleanAppsMCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                new CleanDialog().show(Cleanable.this.getParentFragmentManager(), "");
                Home.cleanableBottomSheet.dismiss();
            }
        });
    }
}
