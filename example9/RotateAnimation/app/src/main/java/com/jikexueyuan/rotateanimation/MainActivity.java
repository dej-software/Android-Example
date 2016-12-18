package com.jikexueyuan.rotateanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRotateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                ra.setDuration(1000);
//                v.startAnimation(ra);
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.ra));
            }
        });
    }
}
