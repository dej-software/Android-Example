package com.jikexueyuan.dragthepic;

import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private View rootView;

    private int actionBarHeight;
    private int notifiHeight;

    private ImageView moveImageView;

    private float diffX, diffY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = getLayoutInflater().inflate(R.layout.activity_main, null);
        rootView.post(new Runnable() {
            @Override
            public void run() {
                if (getSupportActionBar() != null) {
                    actionBarHeight = getSupportActionBar().getHeight();

                    Rect frame = new Rect();
                    getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
                    notifiHeight = frame.top;

//                    System.out.println("actionBarHeight:" + actionBarHeight +"\tnotifiHeight:" + notifiHeight);
                }
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int actionTag = MotionEventCompat.getActionMasked(event);
        int pointerIndex = MotionEventCompat.getActionIndex(event);

        switch (actionTag) {
            case MotionEvent.ACTION_DOWN:

//                System.out.println("X位置:" + getPointerTouchX(event, pointerIndex) + "Y位置:" + getPointerTouchY(event, pointerIndex));
                RelativeLayout.LayoutParams downParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                if (getPointerTouchX(event, pointerIndex) > downParams.leftMargin &&
                        getPointerTouchX(event, pointerIndex) < (downParams.leftMargin + imageView.getWidth()) &&
                        (getPointerTouchY(event, pointerIndex) - actionBarHeight - notifiHeight) > downParams.topMargin &&
                        (getPointerTouchY(event, pointerIndex) - actionBarHeight - notifiHeight) < (downParams.topMargin + imageView.getHeight())) {

                    moveImageView = imageView;

                    diffX = getPointerTouchX(event, pointerIndex) - downParams.leftMargin;
                    diffY = getPointerTouchY(event, pointerIndex) - downParams.topMargin - actionBarHeight - notifiHeight;
                }

                break;
            case MotionEvent.ACTION_MOVE:

                if (moveImageView != null) {
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) moveImageView.getLayoutParams();
                    params.leftMargin = (int) (getPointerTouchX(event, pointerIndex) - diffX);
                    params.topMargin = (int) (getPointerTouchY(event, pointerIndex) - diffY - actionBarHeight - notifiHeight);
                    moveImageView.setLayoutParams(params);
                }

                break;
            case MotionEvent.ACTION_UP:

                moveImageView = null;

                break;
        }

        return super.onTouchEvent(event);
    }

    private float getPointerTouchX(MotionEvent event, int pointerIndex) {
        return MotionEventCompat.getX(event, pointerIndex);
    }

    private float getPointerTouchY(MotionEvent event, int pointerIndex) {
        return MotionEventCompat.getY(event, pointerIndex);
    }
}
