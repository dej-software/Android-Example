package com.jikexueyuan.alphaanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlphaAnimation aa = new AlphaAnimation(0, 1);
//                aa.setDuration(1000);
//                v.startAnimation(aa);
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.aa));
            }
        });
    }
}
