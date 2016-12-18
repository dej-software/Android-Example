package com.jikexueyuan.usingtouchevent;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by dej on 2016/10/16.
 */
public class LinearLayout2 extends LinearLayout {

    public LinearLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        System.out.println("onInterceptTouchEvent : " + super.onInterceptTouchEvent(ev));
        int actionTag = MotionEventCompat.getActionMasked(ev);

        switch (actionTag) {
            case MotionEvent.ACTION_DOWN:
                showLog("onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                showLog("onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                showLog("onInterceptTouchEvent ACTION_UP");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        System.out.println("onTouchEvent : " + super.onTouchEvent(event));
        int actionTag = MotionEventCompat.getActionMasked(event);

        switch (actionTag) {
            case MotionEvent.ACTION_DOWN:
                showLog("onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                showLog("onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                showLog("onTouchEvent ACTION_UP");
                break;
        }
//        return super.onTouchEvent(event);
        return true;
    }

    private void showLog(String str) {
        System.out.println("LinearLayout 2 : " + str);
    }
}
