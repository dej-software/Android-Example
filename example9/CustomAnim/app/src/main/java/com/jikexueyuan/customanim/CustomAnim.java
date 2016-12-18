package com.jikexueyuan.customanim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by dej on 2016/10/10.
 */
public class CustomAnim extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        System.out.println("init");
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
//        System.out.println("interpolatedTime:" + interpolatedTime);
//        t.setAlpha(interpolatedTime);
//        t.getMatrix().setTranslate(200 * interpolatedTime, 200 * interpolatedTime);
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime * 20) * 50), 0);
        super.applyTransformation(interpolatedTime, t);
    }
}
