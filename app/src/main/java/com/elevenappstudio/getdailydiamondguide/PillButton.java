package com.elevenappstudio.getdailydiamondguide;

import android.content.Context;
import android.content.res.TypedArray;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;

public class PillButton extends ConstraintLayout {
    private ImageView chevronView;
    private MaterialCardView iconContainer;
    private ImageView iconView;
    private boolean isHidden = false;
    private MaterialCardView pillContainer;
    private TextView subtitleView;
    private TextView textView;
    private TransitionSet transitionSet;

    public PillButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public PillButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PillButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.pill_button_layout, this, true);
        this.iconContainer = (MaterialCardView) findViewById(R.id.materialCardView7);
        this.pillContainer = (MaterialCardView) findViewById(R.id.pillButton);
        this.iconView = (ImageView) findViewById(R.id.icon);
        this.chevronView = (ImageView) findViewById(R.id.chevron);
        this.textView = (TextView) findViewById(R.id.text);
        this.subtitleView = (TextView) findViewById(R.id.textView41);
        TransitionSet transitionSet2 = new TransitionSet();
        this.transitionSet = transitionSet2;
        transitionSet2.addTransition(new Slide(Gravity.BOTTOM)).addTransition(new Fade()).setDuration(700);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PillButton);
            try {
                setPillBackground(obtainStyledAttributes.getColor(R.styleable.PillButton_pillColor, context.getColor(R.color.game_card_background)));
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PillButton_icon, 0);
                if (resourceId != 0) {
                    setIcon(resourceId);
                }
                String string = obtainStyledAttributes.getString(R.styleable.PillButton_text);
                if (string != null) {
                    setText(string);
                }
                setTextColor(obtainStyledAttributes.getColor(R.styleable.PillButton_textColor, context.getColor(R.color.font)));
                String string2 = obtainStyledAttributes.getString(R.styleable.PillButton_subtitle);
                if (string2 != null) {
                    setSubtitle(string2);
                }
                setChevronVisibility(obtainStyledAttributes.getBoolean(R.styleable.PillButton_chevronVisible, true));
                setIconSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.PillButton_iconSize, getResources().getDimensionPixelSize(R.dimen.default_icon_size)));
                setSubtitleVisible(obtainStyledAttributes.getBoolean(R.styleable.PillButton_subtitleVisible, true));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setIcon(int i) {
        if (i != 0) {
            this.iconView.setBackgroundResource(i);
            this.iconContainer.setVisibility(View.VISIBLE);
            return;
        }
        this.iconContainer.setVisibility(8);
    }

    public void setPillBackground(int i) {
        if (i != 0) {
            try {
                this.pillContainer.setCardBackgroundColor(ContextCompat.getColor(getContext(), i));
            } catch (Exception e) {
                e.printStackTrace();
                this.pillContainer.setCardBackgroundColor(i);
            }
        } else {
            this.pillContainer.setCardBackgroundColor(i);
        }
    }

    public void setTextColor(int i) {
        if (i != 0) {
            try {
                this.textView.setTextColor(ContextCompat.getColor(getContext(), i));
            } catch (Exception e) {
                e.printStackTrace();
                this.textView.setTextColor(i);
            }
        } else {
            this.textView.setTextColor(i);
        }
    }

    public void setText(String str) {
        if (str == null || str.isEmpty()) {
            this.textView.setVisibility(View.GONE);
            return;
        }
        this.textView.setText(str);
        this.textView.setVisibility(View.VISIBLE);
    }

    public void setSubtitle(String str) {
        if (str == null || str.isEmpty()) {
            this.subtitleView.setVisibility(View.GONE);
            return;
        }
        this.subtitleView.setText(str);
        this.subtitleView.setVisibility(View.VISIBLE);
    }

    public void setSubtitleVisible(boolean z) {
        this.subtitleView.setVisibility(z ? View.VISIBLE : View.GONE);
    }

    public void setChevronVisibility(boolean z) {
        this.chevronView.setVisibility(z ? View.VISIBLE : View.GONE);
    }

    public void setIconSize(int i) {
        ViewGroup.LayoutParams layoutParams = this.iconView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.iconView.setLayoutParams(layoutParams);
    }

    public void hide() {
        if (!this.isHidden) {
            this.isHidden = true;
            TransitionManager.beginDelayedTransition((ConstraintLayout) getParent(), this.transitionSet);
            setVisibility(8);
        }
    }

    public void show() {
        if (this.isHidden) {
            this.isHidden = false;
            TransitionManager.beginDelayedTransition((ConstraintLayout) getParent(), this.transitionSet);
            setVisibility(View.VISIBLE);
        }
    }

}


