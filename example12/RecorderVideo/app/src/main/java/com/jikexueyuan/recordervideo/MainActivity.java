package com.jikexueyuan.recordervideo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int VIDEO_RECORDER = 100;
    private Button btnStartRecorder, btnPlayRecorder;
    private VideoView vvPlay;
    private Uri outputUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vvPlay = (VideoView) findViewById(R.id.vvPlay);

        btnStartRecorder = (Button) findViewById(R.id.btnStartRecorder);
        btnPlayRecorder = (Button) findViewById(R.id.btnPlayRecorder);

        btnStartRecorder.setOnClickListener(this);
        btnPlayRecorder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartRecorder:
                File file = new File(Environment.getExternalStorageDirectory(), "myRecorder.mp4");
                outputUri = Uri.fromFile(file);
                System.out.println("PATH:" + outputUri.getPath());
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
                startActivityForResult(intent, VIDEO_RECORDER);
                break;
            case R.id.btnPlayRecorder:
                vvPlay.setVideoURI(outputUri);
                MediaController controller = new MediaController(this);
                vvPlay.setMediaController(controller);
                vvPlay.start();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((resultCode == RESULT_OK) && (requestCode == VIDEO_RECORDER)) {
//            outputUri = data.getData();
        }
    }
}
