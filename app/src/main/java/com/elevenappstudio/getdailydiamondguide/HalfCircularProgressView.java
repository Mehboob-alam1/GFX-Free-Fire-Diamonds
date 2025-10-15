package com.elevenappstudio.getdailydiamondguide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class HalfCircularProgressView extends View {
    private Paint backgroundPaint;
    private Paint foregroundPaint;
    private float progress = 64.0f;
    private RectF rectF;
    private Paint textPaint;

    public HalfCircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.backgroundPaint = paint;
        paint.setColor(Color.parseColor("#E0E0E0"));
        this.backgroundPaint.setAntiAlias(true);
        this.backgroundPaint.setStyle(Paint.Style.STROKE);
        this.backgroundPaint.setStrokeWidth(30.0f);
        Paint paint2 = new Paint();
        this.foregroundPaint = paint2;
        paint2.setColor(Color.parseColor("#2196F3"));
        this.foregroundPaint.setAntiAlias(true);
        this.foregroundPaint.setStyle(Paint.Style.STROKE);
        this.foregroundPaint.setStrokeWidth(30.0f);
        Paint paint3 = new Paint();
        this.textPaint = paint3;
        paint3.setColor(Color.parseColor("#2196F3"));
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(60.0f);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.rectF = new RectF();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = (float) getWidth();
        float height = (float) getHeight();
        Math.min(width, height);
        this.rectF.set(0.0f, 0.0f, width, height * 2.0f);
        canvas.drawArc(this.rectF, 180.0f, 180.0f, false, this.backgroundPaint);
        canvas.drawArc(this.rectF, 180.0f, (this.progress / 100.0f) * 180.0f, false, this.foregroundPaint);
        float f = width / 2.0f;
        canvas.drawText(((int) this.progress) + "%", f, height - (this.textPaint.getTextSize() * 1.5f), this.textPaint);
        canvas.drawText("used space", f, height - (this.textPaint.getTextSize() * 0.2f), this.textPaint);
    }

    public void setProgress(float f) {
        this.progress = f;
        invalidate();
    }
}


