package com.soragoto.cola.animation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import info.nukoneko.android.lib.nkanimation.NKAnimationBaseController;

/**
 * Created by cola on 2016/12/28.
 */

public final class AnimeController extends NKAnimationBaseController {

    float stateCount = 0.0f;
    float x = 200, y = 200;
    Float ox = null;
    Float oy = null;
    int value = 0;
    @Override
    public void onUpdate() {
        stateCount += 0.054f;
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

        final float px1 = ox - 200 * (float) Math.sin( stateCount  ) ;
        final float py1 = oy - 200 * (float) Math.cos( stateCount  ) ;
        final float px2 = ox - 200 * (float) Math.sin( stateCount + 0.054f * 40 );
        final float py2 = oy - 200 * (float) Math.cos( stateCount + 0.054f * 40 );

        c.drawLine( px1, py1 ,px2, py2, paint);
        c.drawPoint( px1, py1, paint);
        c.drawPoint( px2, py2, paint);
        c.drawCircle( ox, oy, value, paint);
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
