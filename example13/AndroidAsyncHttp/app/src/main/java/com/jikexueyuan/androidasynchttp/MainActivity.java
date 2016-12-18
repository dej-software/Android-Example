package com.jikexueyuan.androidasynchttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_a, edt_b;
    private Button btn, btnDownImg;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_a = (EditText) findViewById(R.id.edt_a);
        edt_b = (EditText) findViewById(R.id.edt_b);
        btn = (Button) findViewById(R.id.btn);
        btnDownImg = (Button) findViewById(R.id.btnDownImg);
        textView = (TextView) findViewById(R.id.myTextView);
        imageView = (ImageView) findViewById(R.id.myImageView);

        btn.setOnClickListener(this);
        btnDownImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn:
                calculation();
                break;
            case R.id.btnDownImg:
                downImage();
                break;
        }
    }

    private void downImage() {
        AsyncHttpClientManager.get("http://tupian.enterdesk.com/2012/1029/zyz/03/14583115_1350966109847.jpg", new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                InputStream inputStream = null;
                Bitmap bitmap = null;
                try {
                    inputStream = new FileInputStream(file);
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void calculation() {
        String a = edt_a.getText().toString();
        String b = edt_b.getText().toString();

        RequestParams params = new RequestParams();
        params.add("a", a);
        params.add("b", b);

        AsyncHttpClientManager.get("http://10.0.2.2/test/index.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println("onSuccess: " + statusCode);
                try {
                    showResult(new String(responseBody, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("onFailure: " + statusCode);
            }
        });
    }

    private void showResult(String str) {
        textView.setText(str);
    }
}
