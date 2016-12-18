package com.jikexueyuan.learnlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout root;
    private Button btnClickme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        root = new LinearLayout(this);
        setContentView(root);


//        btnClickme = new Button(this);
//        btnClickme.setText("Click me");

//        root.addView(btnClickme);
//        root.addView(btnClickme, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        root.addView(btnClickme, lp);

        root.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < 5; i++) {
            btnClickme = new Button(this);
            btnClickme.setText("Remove me");
            btnClickme.setOnClickListener(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.weight = 1;
            root.addView(btnClickme, lp);
        }
    }

    @Override
    public void onClick(View v) {
        root.removeView(v);
    }
}
