package com.elevenappstudio.getdailydiamondguide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.elevenappstudio.getdailydiamondguide.Bottomsheets.GFXSettings;
import com.elevenappstudio.getdailydiamondguide.Modal.PrimaryItems;
import com.elevenappstudio.getdailydiamondguide.databinding.GfxItemsLayoutBinding;
import java.util.ArrayList;

public class PrimaryItemAdapter extends RecyclerView.Adapter<PrimaryItemAdapter.MyViewHolder> {
    static Context context;
    static int pos;
    static AdapterView<?> spinnerView;
    GfxItemsLayoutBinding binding;
    ArrayList<PrimaryItems> itemsArrayList;

    public static void saveSelectedItems() {
    }

    public PrimaryItemAdapter(Context context2, ArrayList<PrimaryItems> arrayList) {
        new ArrayList();
        context = context2;
        this.itemsArrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = GfxItemsLayoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new MyViewHolder(this.binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        pos = i;
        PrimaryItems primaryItems = this.itemsArrayList.get(i);
        this.binding.title.setText(primaryItems.getTitle());
        this.binding.subTitle.setText(primaryItems.getSubText());
        this.binding.spinner.setAdapter(SpinnerItems.spinnerAttach(context, primaryItems.getSpinner()));
        this.binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PrimaryItemAdapter.spinnerView = adapterView;
                switch (i) {
                    case 0:
                        GFXSettings.resolution_int = adapterView.getSelectedItemPosition();
                        return;
                    case 1:
                        GFXSettings.fps_int = adapterView.getSelectedItemPosition();
                        return;
                    case 2:
                        GFXSettings.graphicsSpinner = SpinnerItems.graphics[adapterView.getSelectedItemPosition()];
                        return;
                    case 3:
                        GFXSettings.styles_int = adapterView.getSelectedItemPosition();
                        return;
                    case 4:
                        GFXSettings.sound_int = adapterView.getSelectedItemPosition();
                        return;
                    case 5:
                        GFXSettings.water_int = adapterView.getSelectedItemPosition();
                        return;
                    case 6:
                        GFXSettings.shadow_int = adapterView.getSelectedItemPosition();
                        return;
                    case 7:
                        GFXSettings.detail_int = adapterView.getSelectedItemPosition();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
        }
    }
}
