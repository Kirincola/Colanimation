package com.soragoto.cola.animation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

import info.nukoneko.android.lib.nkanimation.NKAnimationBaseController;

/**
 * Created by cola on 2016/12/28.
 */

public final class AnimeController extends NKAnimationBaseController {
    final float tick = 0.1f;
    float stateCount = 0.0f;
    float x = 200, y = 200;
    Float ox = null;
    Float oy = null;
    int value = 200;
    @Override
    public void onUpdate() {
        stateCount += tick;
        if (ox == null) {
            ox = (float) getSurfaceView().getWidth() / 2.0f;
            x = ox;
        }

        if (oy == null) {
            oy = (float) getSurfaceView().getHeight() / 2.0f;
            y = oy;
        }
    }

    @Override
    public void onDraw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 255, 255));
        paint.setStyle(Paint.Style.STROKE);
        c.drawRect(x, y, x + 100 * (float) Math.sin(stateCount), y + 100 * (float) Math.sin(stateCount), paint);

        // *5はスピード調整のためにつけたもの
        final float px1 = ox - value * (float) Math.sin(0.063f * stateCount * 5);
        final float py1 = oy - value * (float) Math.cos(0.063f * stateCount * 5);
        final float px2 = ox - value * (float) Math.sin(0.063f * (stateCount * 5 + 20));
        final float py2 = oy - value * (float) Math.cos(0.063f * (stateCount * 5 + 20));
        final float px3 = ox - value * (float) Math.sin(0.063f * (stateCount * 5 + 40));
        final float py3 = oy - value * (float) Math.cos(0.063f * (stateCount * 5 + 40));
        final float px4 = ox - value * (float) Math.sin(0.063f * (stateCount * 5 + 60));
        final float py4 = oy - value * (float) Math.cos(0.063f * (stateCount * 5 + 60));
        final float px5 = ox - value * (float) Math.sin(0.063f * (stateCount * 5 + 80));
        final float py5 = oy - value * (float) Math.cos(0.063f * (stateCount * 5 + 80));

        Path penta = new Path();
        penta.moveTo(px1, py1);
        penta.lineTo(px4, py4);
        penta.lineTo(px2, py2);
        penta.lineTo(px5, py5);
        penta.lineTo(px3, py3);
        penta.lineTo(px1, py1);
        c.drawPath(penta, paint);
        c.drawCircle(ox, oy, value, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return super.onTouchEvent(event);
    }
    public void setValue(int value){
        this.value = value;
    }
}
