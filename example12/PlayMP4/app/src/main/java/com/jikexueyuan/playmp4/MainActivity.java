package com.jikexueyuan.playmp4;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String fileName = "mv.mp4";
    private Button btnPlayIntent, btnPlayVV;
    private VideoView vvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayIntent = (Button) findViewById(R.id.btnPlayIntent);
        btnPlayIntent.setOnClickListener(this);
        btnPlayVV = (Button) findViewById(R.id.btnPlayVV);
        btnPlayVV.setOnClickListener(this);

        vvMain = (VideoView) findViewById(R.id.vvMain);

        if (!fileExists(fileName)) {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
            // raw下MP4比较大 安装APP时比较慢 所以后面调试时更改raw文件名 需要请自行到res目录下修改回来
            //copyToMobile(fileName);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlayIntent:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("file://" + getDir() + fileName), "video/mp4");
                startActivity(intent);
                break;
            case R.id.btnPlayVV:
                vvMain.setVideoPath(getDir() + fileName);
                MediaController controller = new MediaController(this);
                vvMain.setMediaController(controller);
                vvMain.start();
                break;
        }
    }

    private String getDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/myplayer/";
    }

    private boolean fileExists(String fileName) {
        File file = new File(getDir() + fileName);
        if (file.exists()) {
            return true;
        }

        return false;
    }

    private void copyToMobile(final String fileName) {
        new Thread() {
            @Override
            public void run() {
                super.run();

                File dir = new File(getDir());
                if (!dir.exists()) {
                    dir.mkdir();
                }

                InputStream fis = null;
                OutputStream fos = null;
//                fis = getResources().openRawResource(R.raw.mv);
                File to = new File(getDir(), fileName);

                try {
                    fos = new FileOutputStream(to);

                    byte[] buf = new byte[4096];
                    while (fis.read(buf) != -1) {
                        fos.write(buf);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
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
            }
        }.start();
    }
}
