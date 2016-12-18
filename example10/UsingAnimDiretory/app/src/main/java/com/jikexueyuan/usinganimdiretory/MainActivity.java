package com.jikexueyuan.usinganimdiretory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Animation outAnim, inAnim;
    private boolean isRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(this);
        outAnim = AnimationUtils.loadAnimation(this, R.anim.anim_out);
        inAnim = AnimationUtils.loadAnimation(this, R.anim.anim_in);
    }

    @Override
    public void onClick(View v) {
        if (isRotate) {
            imageView.startAnimation(outAnim);
        } else {
            imageView.startAnimation(inAnim);
        }
        isRotate = !isRotate;
    }
}
