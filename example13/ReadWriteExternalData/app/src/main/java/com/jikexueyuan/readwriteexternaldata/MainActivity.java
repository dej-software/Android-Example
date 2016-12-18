package com.jikexueyuan.readwriteexternaldata;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInput;
    private TextView tvShow;
    private Button btnWrite, btnRead;
    private File sdcardPath;
    private File myFile;

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

        sdcardPath = Environment.getExternalStorageDirectory();
        if (!sdcardPath.exists()) {
            Toast.makeText(this, "当前系统无SD卡目录", Toast.LENGTH_SHORT).show();
            btnWrite.setEnabled(false);
            btnRead.setEnabled(false);
        }
        myFile = new File(sdcardPath, "myFile.txt");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                if (!myFile.exists()) {
                    try {
                        myFile.createNewFile();
                        Toast.makeText(this, "文件已创建", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileOutputStream fos = null;
                OutputStreamWriter osw = null;
//                BufferedWriter bfw = null;
                try {
                    fos = new FileOutputStream(myFile);
                    osw = new OutputStreamWriter(fos, "UTF-8");
                    osw.write(etInput.getText().toString());
                    osw.flush();
                    fos.flush();
                    Toast.makeText(this, "写入完成", Toast.LENGTH_SHORT).show();
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
                if (!myFile.exists()) {
                    Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
                    return;
                }
                FileInputStream fis = null;
                InputStreamReader isr = null;
                try {
                    fis = new FileInputStream(myFile);
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
