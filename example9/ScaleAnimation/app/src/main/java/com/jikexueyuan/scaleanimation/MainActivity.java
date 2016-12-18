package com.jikexueyuan.scaleanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnScaleMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                sa.setDuration(1000);
//                v.startAnimation(sa);
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.sa));
            }
        });
    }
}
