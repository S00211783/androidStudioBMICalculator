package com.example.bodymassindexapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BMIGaugeView extends View {
    private Paint gaugePaint;
    private float bmiValue; // The BMI value to display in the gauge

    public BMIGaugeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        gaugePaint = new Paint();
        gaugePaint.setAntiAlias(true);
        gaugePaint.setStyle(Paint.Style.STROKE);
        gaugePaint.setStrokeWidth(20); // Adjust the gauge's thickness as needed
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Define the circle's center and radius
        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;
        float radius = Math.min(centerX, centerY) - gaugePaint.getStrokeWidth() / 2;

        // Set the gauge color (you can customize this)
        gaugePaint.setColor(getGaugeColor(bmiValue));

        // Draw the arc representing the BMI gauge
        float startAngle = 135; // Start angle in degrees
        float sweepAngle = 270; // Sweep angle in degrees
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, startAngle, sweepAngle, false, gaugePaint);
    }

    public void setBMIValue(float bmiValue) {
        this.bmiValue = bmiValue;
        invalidate(); // Trigger a redraw of the gauge when the BMI value changes
    }

    // Define your custom color scheme for the gauge based on BMI values
    private int getGaugeColor(float bmiValue) {
        // Customize the color based on your desired ranges
        if (bmiValue < 18.5) {
            return Color.GREEN;
        } else if (bmiValue >= 18.5 && bmiValue < 24.9) {
            return Color.YELLOW;
        } else {
            return Color.RED;
        }
    }
}
