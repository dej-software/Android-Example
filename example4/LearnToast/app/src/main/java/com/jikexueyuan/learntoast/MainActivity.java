package com.jikexueyuan.learntoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnShowToastShort;
    private Button btnShowToastLong;
    private Button btnShowToastImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowToastShort = (Button) findViewById(R.id.btnShowToastShort);
        btnShowToastShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast aShortToast = Toast.makeText(MainActivity.this, "简短的Toast", Toast.LENGTH_SHORT);
                aShortToast.setGravity(Gravity.CENTER, 0, 0);
                aShortToast.show();
            }
        });

        btnShowToastLong = (Button) findViewById(R.id.btnShowToastLong);
        btnShowToastLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "较长的Toast", Toast.LENGTH_LONG).show();
            }
        });

        btnShowToastImage = (Button) findViewById(R.id.btnShowToastImage);
        btnShowToastImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast aImageToast = Toast.makeText(MainActivity.this, "带图片的Toast", Toast.LENGTH_SHORT);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                aImageToast.setView(imageView);
                aImageToast.show();
                aImageToast.show();
            }
        });
    }
}
