package com.jikexueyuan.usinganimatordiretory;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Animator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(this);
        animator = AnimatorInflater.loadAnimator(this, R.animator.anim);
        animator.setTarget(imageView);
    }

    @Override
    public void onClick(View v) {
        animator.start();
    }
}
