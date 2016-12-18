package com.jikexueyuan.mycapture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCapture;
    private ImageView ivCapture;
    private final int TAKE_CAPTURE = 100;

    private Uri outputUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCapture = (Button) findViewById(R.id.btnCapture);
        ivCapture = (ImageView) findViewById(R.id.ivCapture);
        btnCapture.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCapture:
                File file = new File(Environment.getExternalStorageDirectory(), "my.png");
                outputUri = Uri.fromFile(file);
                System.out.println("PATH:" + outputUri.getPath());
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
                startActivityForResult(intent, TAKE_CAPTURE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((resultCode == RESULT_OK) && (requestCode == TAKE_CAPTURE)) {

            if (data != null) {
                if (data.hasExtra("data")) {
                    Bitmap bitmap = data.getParcelableExtra("data");
                    ivCapture.setImageBitmap(bitmap);
                }
            } else {
                System.out.println("Custom Path");
                int width = ivCapture.getWidth();
                int height = ivCapture.getHeight();

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(outputUri.getPath(), options);

                int imgWidth = options.outWidth;
                int imgHeight = options.outHeight;

                int scale = Math.min(imgWidth / width, imgHeight / height);
                scale = (scale == 0 ? 1 : scale);

                options.inJustDecodeBounds = false;
                options.inSampleSize = scale;

                Bitmap bitmap = BitmapFactory.decodeFile(outputUri.getPath(), options);
                ivCapture.setImageBitmap(bitmap);
            }
        }
    }
}
