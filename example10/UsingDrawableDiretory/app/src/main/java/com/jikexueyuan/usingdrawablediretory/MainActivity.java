package com.jikexueyuan.usingdrawablediretory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.my_level_list_img);

        int a = 2;
        switch (a) {
            case 1:
                imageView.getDrawable().setLevel(1);
                break;
            case 2:
                imageView.getDrawable().setLevel(2);
                break;
        }
    }
}
