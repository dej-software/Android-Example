package com.jikexueyuan.audiorecorder;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by dej on 2016/10/22.
 */
public class AudioPlayer {

    private MediaPlayer mediaPlayer;

    public String getPlayerPath() {
        return playerPath;
    }

    public void setPlayerPath(String playerPath) {
        this.playerPath = playerPath;
    }

    private String playerPath;

    public AudioPlayer() {
    }

    public AudioPlayer(String playerPath) {
        this.playerPath = playerPath;
    }

    public void play() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        try {
            mediaPlayer.setDataSource(playerPath);
            mediaPlayer.prepare();
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer = null;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
