package com.jikexueyuan.learnmyrect;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dej on 2016/10/4.
 * 学习自定义视图
 */
public class MyRect extends View {
    public MyRect(Context context) {
        super(context);
    }

    public MyRect(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);

        int color = ta.getColor(R.styleable.MyView_rect_color, 0xffff0000);
        setBackgroundColor(color);

        ta.recycle();
    }
}
