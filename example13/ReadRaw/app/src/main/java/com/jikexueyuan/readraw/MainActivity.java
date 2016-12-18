package com.jikexueyuan.readraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ReadRaw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnReadRaw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream is = null;
                InputStreamReader isr = null;
                BufferedReader bfr = null;
                try {
                    is = getResources().openRawResource(R.raw.info);
                    isr = new InputStreamReader(is, "UTF-8");
                    bfr = new BufferedReader(isr);
                    String str = "";
                    while ((str = bfr.readLine()) != null) {
                        Log.i(TAG, str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bfr != null) {
                        try {
                            bfr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (isr != null) {
                        try {
                            isr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
