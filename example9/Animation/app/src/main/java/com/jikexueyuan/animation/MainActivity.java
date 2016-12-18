package com.jikexueyuan.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AnimationSet as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        as = new AnimationSet(true);

        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1000);
        as.addAnimation(aa);

        final TranslateAnimation ta = new TranslateAnimation(200, 0, 200, 0);
        ta.setDuration(1000);
        as.addAnimation(ta);

        findViewById(R.id.btnAnimMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                v.startAnimation(ta);

                Animation a= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
                a.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                v.startAnimation(a);
            }
        });
    }
}
