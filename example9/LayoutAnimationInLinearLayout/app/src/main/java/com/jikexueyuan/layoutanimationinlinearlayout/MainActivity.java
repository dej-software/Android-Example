package com.jikexueyuan.layoutanimationinlinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llAnim = (LinearLayout) findViewById(R.id.ll_anim);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        sa.setDuration(500);

        LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5f);
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);

        llAnim.setLayoutAnimation(lac);
    }
}
