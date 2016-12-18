package com.jikexueyuan.learndrawapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dej on 2016/10/4.
 */
public class RotatingRect extends View {
    public RotatingRect(Context context) {
        super(context);
        initProperties();
    }

    public RotatingRect(Context context, AttributeSet attrs) {
        super(context, attrs);
        initProperties();
    }

    public RotatingRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initProperties();
    }

    private void initProperties() {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.save();
        canvas.translate(400, 400);
//        canvas.rotate(degrees);
        canvas.rotate(degrees, 100, 100);
        canvas.drawRect(0, 0, 200, 200, paint);

        degrees++;
        canvas.restore();

        invalidate();
    }

    private Paint paint;
    private float degrees = 0;
}
