package com.elevenappstudio.getdailydiamondguide.Bottomsheets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.elevenappstudio.getdailydiamondguide.Constants;
import com.elevenappstudio.getdailydiamondguide.R;
import com.elevenappstudio.getdailydiamondguide.databinding.BottomsheetShizukuInstructBinding;

public class ShizukuPermissionBS {
    private static final String APP_PACKAGE_NAME = "moe.shizuku.privileged.api";
    public static BottomsheetShizukuInstructBinding binding;
    public static BottomSheetDialog dialog;

    public static void Show(final Context context) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);
        dialog = bottomSheetDialog;
        bottomSheetDialog.setCancelable(true);
        dialog.setDismissWithAnimation(true);
        BottomsheetShizukuInstructBinding inflate = BottomsheetShizukuInstructBinding.inflate(LayoutInflater.from(context));
        binding = inflate;
        dialog.setContentView((View) inflate.getRoot());
        binding.shizukuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                ShizukuPermissionBS.dismiss(context);
                PackageManager packageManager = context.getPackageManager();
                try {
                    packageManager.getPackageInfo("moe.shizuku.privileged.api", 1);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("moe.shizuku.privileged.api");
                    if (launchIntentForPackage != null) {
                        context.startActivity(launchIntentForPackage);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=moe.shizuku.privileged.api")));
                }
            }
        });
        binding.ytVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.performHapticFeedback(1, 2);
                ShizukuPermissionBS.dismiss(context);
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.SHIZUKU_VIDEO_LINK)));
            }
        });
        if (!((Activity) context).isFinishing()) {
            dialog.show();
        }
    }

    public static void dismiss(Context context) {
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (ShizukuPermissionBS.dialog.isShowing()) {
                    ShizukuPermissionBS.dialog.dismiss();
                }
            }
        });
    }
}
