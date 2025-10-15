package com.elevenappstudio.getdailydiamondguide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircularProgressView extends View {
    private Paint backgroundPaint;
    private float progress = 0.0f;
    private Paint progressPaint;
    private String progressText = "10%";
    private RectF rectF;
    private Paint textPaint;

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.backgroundPaint = paint;
        paint.setColor(Color.parseColor("#E6E6FA"));
        this.backgroundPaint.setStyle(Paint.Style.STROKE);
        this.backgroundPaint.setStrokeWidth(40.0f);
        this.backgroundPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.progressPaint = paint2;
        paint2.setColor(Color.parseColor("#4169E1"));
        this.progressPaint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeWidth(40.0f);
        this.progressPaint.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.textPaint = paint3;
        paint3.setColor(-16777216);
        this.textPaint.setTextSize(60.0f);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setAntiAlias(true);
        this.rectF = new RectF();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int min = (Math.min(width, height) / 2) - 20;
        int i = width / 2;
        int i2 = height / 2;
        this.rectF.set((float) (i - min), (float) (i2 - min), (float) (i + min), (float) (min + i2));
        canvas.drawArc(this.rectF, 0.0f, 360.0f, false, this.backgroundPaint);
        canvas.drawArc(this.rectF, -90.0f, this.progress * 3.6f, false, this.progressPaint);
        canvas.drawText(this.progressText, (float) i, ((float) i2) + (((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent()), this.textPaint);
    }

    public void setProgress(float f) {
        this.progress = f;
        this.progressText = ((int) f) + "%";
        invalidate();
    }
}


