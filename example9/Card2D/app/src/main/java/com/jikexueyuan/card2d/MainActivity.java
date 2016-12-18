package com.jikexueyuan.card2d;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageA, imageB;

    // 以中心的Scale动画  实现2D翻转的效果
    private ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    private ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        imageA = (ImageView) findViewById(R.id.ivA);
        imageB = (ImageView) findViewById(R.id.ivB);

        showImageA();

        sato0.setDuration(500);
        sato1.setDuration(500);

        sato0.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (imageA.getVisibility() == View.VISIBLE) {
                    imageA.setAnimation(null);
                    showImageB();
                    imageB.startAnimation(sato1);
                } else {
                    imageB.setAnimation(null);
                    showImageA();
                    imageA.startAnimation(sato1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (imageA.getVisibility() == View.VISIBLE) {
//
//                    imageA.startAnimation(sato0);
//                } else {
//                    imageB.startAnimation(sato0);
//                }
                ObjectAnimator.ofFloat(imageA, "scaleX", 1, 0).setDuration(1000).start();
                showImageB();
                ObjectAnimator.ofFloat(imageB, "scaleX", 0, 1).setDuration(1000).start();
//                ObjectAnimator.ofFloat(imageB, "scaleX", 1, 0).setDuration(1000).start();
//                showImageA();
//                ObjectAnimator.ofFloat(imageA, "scaleX", 0, 1).setDuration(1000).start();
            }
        });
    }

    private void showImageA() {
        imageA.setVisibility(View.VISIBLE);
        imageB.setVisibility(View.INVISIBLE);
    }

    private void showImageB() {
        imageA.setVisibility(View.INVISIBLE);
        imageB.setVisibility(View.VISIBLE);
    }
}
