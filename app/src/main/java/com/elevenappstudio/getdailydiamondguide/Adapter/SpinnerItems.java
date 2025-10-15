package com.elevenappstudio.getdailydiamondguide.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.elevenappstudio.getdailydiamondguide.R;

public class SpinnerItems {
    public static String[] anti_aliasing = {"Disable", "2x", "4x"};
    public static String[] detail = {"Less", "Medium", "Show all"};
    public static String[] effects = {"Default", "Low", "Medium", "High", "Ultra"};
    public static String[] fps = {"Default", "30FPS", "40FPS", "60FPS", "90FPS", "120FPS"};
    public static String[] graphics = {"Default", "Smooth", "Balanced", "HD", "HDR", "Ultra", "Super Smooth"};
    public static String[] render = {"Default", "Low", "Medium", "High", "Ultra"};
    public static String[] resolution = {"Default", "144p", "360p", "480p", "540p", "640p", "720p", "1080p", "1080p HD+", "1440p"};
    public static String[] shadow = {"Disable", "Enable"};
    public static String[] skipGames = {"com.pubg.imobile", "com.tencent.ig", "com.pubg.krmobile", "com.rekoo.pubgm", "com.vng.pubgmobile"};
    public static String[] sound = {"Low", "High", "Ultra"};
    public static String[] styles = {"Classic", "Colorful", "Realistic", "Soft", "Movie"};
    public static String[] texture = {"Default", "Low", "Medium", "High", "Ultra"};
    public static String[] water = {"Disable", "Enable"};

    public static ArrayAdapter<CharSequence> spinnerAttach(Context context, String[] strArr) {
        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<>(context, R.layout.spinner_text, strArr);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        return arrayAdapter;
    }
}
