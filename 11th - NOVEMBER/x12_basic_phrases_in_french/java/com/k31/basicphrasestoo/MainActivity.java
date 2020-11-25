package com.k31.basicphrasestoo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    public void playSound(View view){

        Button buttonChecker = (Button) view;

        Log.i("info", buttonChecker.getTag().toString());

        mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonChecker.getTag().toString(), "raw", getPackageName()));

        mediaPlayer.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}