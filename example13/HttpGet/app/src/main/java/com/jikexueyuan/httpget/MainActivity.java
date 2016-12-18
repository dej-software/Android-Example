package com.jikexueyuan.httpget;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnHttpGet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("HttpGet");
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        try {
                            URL url = new URL(params[0]);
                            URLConnection connection = url.openConnection();
                            InputStream is = connection.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                            BufferedReader br = new BufferedReader(isr);

                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }

                            br.close();
                            isr.close();
                            is.close();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
//                }.execute("http://fanyi.youdao.com/openapi.do?keyfrom=dejHttpGet&key=1674180251&type=data&doctype=xml&version=1.1&q=good");
                }.execute("http://bxu2359110390.my3w.com/latestposts.php");
            }
        });
    }
}
