package com.jikexueyuan.animateme;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimateMe).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        v.animate().rotation(360).setDuration(1000).start();

//        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.animate_me);
//        animator.setTarget(v);
//        animator.start();

//        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animate_me_set);
//        set.setTarget(v);
//        set.start();

//        ObjectAnimator.ofFloat(v, "rotation", 0, 90, 90, 360).setDuration(1000).start();

        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.playSequentially(ObjectAnimator.ofFloat(v, "alpha", 0, 1),
                ObjectAnimator.ofFloat(v, "translationY", 0, 200));
        set.start();
    }
}
