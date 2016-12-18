package com.jikexueyuan.learnsurfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dej on 2016/10/4.
 */
public class Circle extends Contanier {

    private Paint paint = null;

    public Circle() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    public void childrenView(Canvas canvas) {
        super.childrenView(canvas);
        canvas.drawCircle(100, 100, 100, paint);
    }
}
