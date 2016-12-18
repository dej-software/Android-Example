package com.jikexueyuan.learnsurfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dej on 2016/10/4.
 */
public class Rect extends Contanier {

    private Paint paint = null;

    public Rect() {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void childrenView(Canvas canvas) {
        super.childrenView(canvas);
        canvas.drawRect(0, 0, 200, 200, paint);
        this.setY(this.getY() + 1);
        this.setX(this.getX() + 1);
    }
}
