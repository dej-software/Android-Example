package com.jikexueyuan.audiorecorder;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dej on 2016/10/22.
 */
public class AudioRecorder {
    private String dir, fileName;
    private MediaRecorder mediaRecorder;

    public AudioRecorder() {
        dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myrecorder/";
    }

    public void start() throws IOException {
        String state = Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            throw new IOException("没有可用的存储空间");
        }

        File myDir = new File(dir);
        if (!myDir.exists()) {
            myDir.mkdir();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("_yyyyMMdd_HHmmss");
        fileName = dir + "AUDIO" + dateFormat.format(new Date(System.currentTimeMillis())) + ".amr";
        System.out.println(fileName);

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setAudioSamplingRate(8000);
        mediaRecorder.setOutputFile(fileName);
        mediaRecorder.prepare();
        mediaRecorder.start();
    }

    public void stop() {
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }

    public String getFileName() {
        return fileName;
    }
}
