package com.jikexueyuan.translateanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnTranslateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 相对自身
//                TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 200);
//                ta.setDuration(1000);
//                v.startAnimation(ta);
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.ta));
            }
        });
    }
}
