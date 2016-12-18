package com.jikexueyuan.learnsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by dej on 2016/10/4.
 */
public class MyView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint paint = null;

    public MyView(Context context) {
        super(context);

        paint = new Paint();
        paint.setColor(Color.RED);
        getHolder().addCallback(this);
    }

    public void draw() {
        Canvas canvas = getHolder().lockCanvas();

        canvas.drawColor(Color.WHITE);
//        canvas.drawRect(0, 0, 200, 200, paint);
        canvas.save();
        canvas.rotate(90, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight(), paint);
        canvas.restore();
        canvas.drawLine(0, getHeight() / 2 + 100, getWidth(), getHeight() + 100, paint);

        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
