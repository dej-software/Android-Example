package com.jikexueyuan.mysocketclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private EditText ip, input;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = (EditText) findViewById(R.id.ip);
        input = (EditText) findViewById(R.id.input);
        text = (TextView) findViewById(R.id.text);

        findViewById(R.id.connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        });

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }

    // ------------------------------------------- //
    Socket socket = null;
    BufferedWriter writer = null;
    BufferedReader reader = null;

    public void connect() {
        final String ipStr = ip.getText().toString();
        System.out.println("IP:" + ipStr);
        AsyncTask<Void, String, Void> read = new AsyncTask<Void, String, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    socket = new Socket(ipStr, 20000);
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    publishProgress("@success");
                } catch (UnknownHostException e) {
                    Toast.makeText(MainActivity.this, "无法建立连接", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "无法建立连接", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                try {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        publishProgress(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                if (values[0].equals("@success")) {
                    Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                }
                text.append("服务器：" + values[0] + "\n");
                super.onProgressUpdate(values);
            }
        };
        read.execute();
    }

    public void send() {
//        if (writer != null) {
            try {
                text.append("本机：" + input.getText().toString() + "\n");
                writer.write(input.getText().toString() + "\n");
                writer.flush();
                input.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
    }
}
