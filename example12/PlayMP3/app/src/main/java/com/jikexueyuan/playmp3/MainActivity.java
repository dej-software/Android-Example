package com.jikexueyuan.playmp3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlayRaw, btnStopPlay, btnPlayIntent, btnPlaySource;
    private MediaPlayer mediaPlayer;
    private String fileName = "music.mp3";
    private boolean isShowPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayRaw = (Button) findViewById(R.id.btnPlayRaw);
        btnPlayRaw.setOnClickListener(this);
        btnStopPlay = (Button) findViewById(R.id.btnStopPlay);
        btnStopPlay.setOnClickListener(this);
        btnPlayIntent = (Button) findViewById(R.id.btnPlayIntent);
        btnPlayIntent.setOnClickListener(this);
        btnPlaySource = (Button) findViewById(R.id.btnPlaySource);
        btnPlaySource.setOnClickListener(this);

        if (!fileExists(fileName)) {
            copyToMobile(fileName);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlayRaw:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.music);
                    mediaPlayer.start();
                    isShowPosition = true;
                    showPosition.start();
                }
                break;
            case R.id.btnPlayIntent:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("file://" + getDir() + fileName), "audio/mp3");
                startActivity(intent);
                break;
            case R.id.btnPlaySource:
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(getDir() + fileName);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btnStopPlay:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    isShowPosition = false;
                    mediaPlayer = null;
                }
                break;
        }
    }

    private Thread showPosition = new Thread(new Runnable() {
        @Override
        public void run() {
            while (isShowPosition) {
                try {
                    System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(mediaPlayer.getCurrentPosition())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    });

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
                fis = getResources().openRawResource(R.raw.music);
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
