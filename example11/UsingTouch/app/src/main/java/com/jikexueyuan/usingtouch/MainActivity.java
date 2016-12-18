package com.jikexueyuan.usingtouch;

import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("onTouchEvent");

//        System.out.println(event.getAction());
//        System.out.println(event.getActionMasked());
//        System.out.println(MotionEventCompat.getActionMasked(event));

//        int actionTag = MotionEventCompat.getActionMasked(event);
//
//        switch (actionTag) {
//            case MotionEvent.ACTION_DOWN:
//                System.out.println("ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                System.out.println("ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_UP:
//                System.out.println("ACTION_UP");
//                break;
//        }

//        System.out.println(MotionEventCompat.getPointerCount(event));
//        int actionIndex = MotionEventCompat.getActionIndex(event);
//        float touchX = MotionEventCompat.getX(event, actionIndex);
//        float touchY = MotionEventCompat.getY(event, actionIndex);
//        System.out.println(touchX + "\t" + touchY);

        for (int i = 0; i < MotionEventCompat.getPointerCount(event); i++) {
            float touchX = MotionEventCompat.getX(event, i);
            float touchY = MotionEventCompat.getY(event, i);
            System.out.println("Pointer " + i + " : " + touchX + "\t" + touchY);
        }

        return super.onTouchEvent(event);
    }
}
