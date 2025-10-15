package com.elevenappstudio.getdailydiamondguide.Bottomsheets;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.elevenappstudio.getdailydiamondguide.Utils.PermissionUtils;
import com.elevenappstudio.getdailydiamondguide.databinding.FragmentAskPermissionBinding;

public class AskPermissionBS extends BottomSheetDialogFragment {
    FragmentAskPermissionBinding binding;
    Context context;
    private String permission;
    private int permission_img;
    private String rationale;

    public static AskPermissionBS newInstance(int i, String str, String str2) {
        AskPermissionBS askPermissionBS = new AskPermissionBS();
        Bundle bundle = new Bundle();
        bundle.putInt("permission_img", i);
        bundle.putString("permission", str);
        bundle.putString("rationale", str2);
        askPermissionBS.setArguments(bundle);
        return askPermissionBS;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.permission_img = getArguments().getInt("permission_img");
            this.permission = getArguments().getString("permission");
            this.rationale = getArguments().getString("rationale");
        }
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentAskPermissionBinding inflate = FragmentAskPermissionBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.context = getContext();
        this.binding.imageView18.setImageDrawable(getResources().getDrawable(this.permission_img));
        this.binding.rationaleTitleTextView.setText(this.permission);
        this.binding.rationaleTextView.setText(this.rationale);
        this.binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AskPermissionBS.this.dismiss();
            }
        });
        this.binding.grantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                AskPermissionBS.this.dismiss();
                PermissionUtils.requestUsageStatsPermission(AskPermissionBS.this.context);
            }
        });
    }
}
