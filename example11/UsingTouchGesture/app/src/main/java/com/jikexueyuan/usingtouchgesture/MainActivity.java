package com.jikexueyuan.usingtouchgesture;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetectorCompat = new GestureDetectorCompat(this, this);
        gestureDetectorCompat.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        showLog("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        showLog("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        showLog("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        showLog("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        showLog("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        showLog("onFling");
        return true;
    }

    private void showLog(String str) {
        System.out.println(str);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        showLog("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        showLog("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        showLog("onDoubleTapEvent");
        return true;
    }
}
