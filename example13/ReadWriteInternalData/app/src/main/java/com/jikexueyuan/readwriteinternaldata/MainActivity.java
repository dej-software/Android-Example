package com.jikexueyuan.readwriteinternaldata;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String fileName = "test";
    private EditText etInput;
    private TextView tvShow;
    private Button btnWrite, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.etInput);
        tvShow = (TextView) findViewById(R.id.tvShow);

        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);

        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                FileOutputStream fos = null;
                OutputStreamWriter osw = null;
//                BufferedWriter bfw = null;
                try {
                    fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    osw = new OutputStreamWriter(fos, "UTF-8");
                    osw.write(etInput.getText().toString());
                    osw.flush();
                    fos.flush();
                    Toast.makeText(this, "写入完成", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (osw != null) {
                        try {
                            osw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case R.id.btnRead:
                FileInputStream fis = null;
                InputStreamReader isr = null;
//                BufferedReader bfr = null;
                try {
                    fis = openFileInput(fileName);
                    isr = new InputStreamReader(fis, "UTF-8");

                    char[] input = new char[fis.available()];
                    isr.read(input);
                    tvShow.setText(new String(input));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (isr != null) {
                        try {
                            isr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
        }
    }
}
