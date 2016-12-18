package com.jikexueyuan.audiorecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartRecorder, btnStopRecorder, btnPlayRecorder, btnStopPlay;
    private AudioRecorder mRecorder;
    private AudioPlayer mPlayer;
    private String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartRecorder = (Button) findViewById(R.id.btnStartRecorder);
        btnStopRecorder = (Button) findViewById(R.id.btnStopRecorder);
        btnPlayRecorder = (Button) findViewById(R.id.btnPlayRecorder);
        btnStopPlay = (Button) findViewById(R.id.btnStopPlay);

        btnStartRecorder.setOnClickListener(this);
        btnStopRecorder.setOnClickListener(this);
        btnPlayRecorder.setOnClickListener(this);
        btnStopPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartRecorder:
                if (mRecorder == null) {
                    mRecorder = new AudioRecorder();
                }
                try {
                    mRecorder.start();
                    fileName = mRecorder.getFileName();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnStopRecorder:
                if (mRecorder != null) {
                    mRecorder.stop();
                }
                break;
            case R.id.btnPlayRecorder:
                if (mPlayer == null) {
                    mPlayer = new AudioPlayer(fileName);
                }
                mPlayer.play();
                break;
            case R.id.btnStopPlay:
                if (mPlayer != null) {
                    mPlayer.stop();
                    mPlayer = null;
                }
                break;
        }
    }
}
