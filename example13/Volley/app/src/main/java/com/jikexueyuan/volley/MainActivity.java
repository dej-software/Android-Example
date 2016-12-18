package com.jikexueyuan.volley;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private TextView myTextView;
    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.myTextView);
        myImageView = (ImageView) findViewById(R.id.myImageView);
        requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest("http://fanyi.youdao.com/openapi.do?keyfrom=dejHttpGet&key=1674180251&type=data&doctype=json&version=1.1&q=hello",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        myTextView.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        myTextView.setText("onErrorResponse");
                    }
                });

        requestQueue.add(stringRequest);

        ImageRequest imageRequest = new ImageRequest("http://tupian.enterdesk.com/2012/1029/zyz/03/14583115_1350966109847.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                myImageView.setImageBitmap(response);
            }
        }, 0, 0, null, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myTextView.append("\n ImageRequest onErrorResponse");
            }
        });

        requestQueue.add(imageRequest);
    }
}
