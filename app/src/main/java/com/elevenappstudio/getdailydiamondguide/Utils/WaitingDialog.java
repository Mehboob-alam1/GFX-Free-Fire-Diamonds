package com.elevenappstudio.getdailydiamondguide.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.elevenappstudio.getdailydiamondguide.R;

public class WaitingDialog extends Dialog {
    public WaitingDialog(Context context) {
        super(context);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        setContentView(R.layout.dialog_waiting);
    }
}
