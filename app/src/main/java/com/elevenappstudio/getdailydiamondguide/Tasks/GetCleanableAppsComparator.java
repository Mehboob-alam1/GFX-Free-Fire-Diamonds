package com.elevenappstudio.getdailydiamondguide.Tasks;

import com.elevenappstudio.getdailydiamondguide.Modal.CleanAppsInfo;
import java.util.Comparator;


public final  class GetCleanableAppsComparator implements Comparator {

    @Override
    public int compare(Object obj, Object obj2) {
        return Long.compare(((CleanAppsInfo) obj2).cacheSize, ((CleanAppsInfo) obj).cacheSize);
    }
}
