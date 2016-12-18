package com.jikexueyuan.usingasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView tvShowRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShowRead = (TextView) findViewById(R.id.tvShowRead);
        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readURL("http://www.sougou.com");
//                readURL("http://bxu2359110390.my3w.com/latestposts.php");
            }
        });
    }

    private void readURL(String url) {
        new AsyncTask<String, Float, String>() {
            @Override
            protected String doInBackground(String... params) {
                try {
                    System.out.println("URL:" + params[0]);
                    URL url = new URL(params[0]);
                    URLConnection connection = url.openConnection();
                    long total = connection.getContentLength();

                    InputStream is = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line;
                    StringBuilder builder = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        builder.append(line);
                        Float values;
                        publishProgress(Float.valueOf(builder.toString().length() / total));
                    }

                    br.close();
                    isr.close();
                    is.close();

                    return builder.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(MainActivity.this, "开始读取", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

//                try {
//                    JSONObject object = new JSONObject(s);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

                tvShowRead.setText(s);
            }

            @Override
            protected void onProgressUpdate(Float... values) {
                super.onProgressUpdate(values);
                System.out.println("读取进度：" + values[0]);
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        }.execute(url);
    }
}
