package com.elevenappstudio.getdailydiamondguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

    private List<OnboardingItem> onboardingItems;
    private OnboardingClickListener clickListener;

    public interface OnboardingClickListener {
        void onNextClicked(int position, String url);
    }

    public OnboardingAdapter(List<OnboardingItem> onboardingItems, OnboardingClickListener clickListener) {
        this.onboardingItems = onboardingItems;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_onboarding, parent, false);
        return new OnboardingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        OnboardingItem item = onboardingItems.get(position);
        
        holder.image.setImageResource(item.getImageResId());
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
        
        // Update button text for last page
        if (position == onboardingItems.size() - 1) {
            holder.nextButton.setText("Get Started");
        } else {
            holder.nextButton.setText("Next");
        }
        
        holder.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onNextClicked(position, item.getUrl());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return onboardingItems.size();
    }

    static class OnboardingViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView subtitle;
        Button nextButton;

        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.onboardingImage);
            title = itemView.findViewById(R.id.onboardingTitle);
            subtitle = itemView.findViewById(R.id.onboardingSubtitle);
            nextButton = itemView.findViewById(R.id.nextButton);
        }
    }
}

