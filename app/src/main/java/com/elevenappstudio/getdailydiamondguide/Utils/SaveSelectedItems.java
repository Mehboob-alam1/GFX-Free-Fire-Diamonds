package com.elevenappstudio.getdailydiamondguide.Utils;

import android.content.Context;
import com.elevenappstudio.getdailydiamondguide.Constants;
import java.util.ArrayList;

public class SaveSelectedItems {
    public static void setGameSpinnerItems(Context context, ArrayList<Integer> arrayList) {
        new TinyDB(context).putListInt(Constants.GAME_SPINNER_ITEMS, arrayList);
    }

    public static ArrayList getGameSpinnerItems(Context context) {
        return new TinyDB(context).getListInt(Constants.GAME_SPINNER_ITEMS);
    }
}
