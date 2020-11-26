package com.k31.eggtimers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int startingTime = 10;

    boolean go;

    public void goStopTime(View view){
        Button buttonName = (Button) findViewById(R.id.goStopButton);

        if (go) {
            buttonName.setText("GO");
            go = false;
        } else {

            buttonName.setText("STOP");
            go = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // seekbar thing
        SeekBar timerSeekerBar = findViewById(R.id.timerSeekBar);
        TextView textView = (TextView) findViewById(R.id.editTextTime);
        textView.setText(String.valueOf(startingTime));


        timerSeekerBar.setProgress(startingTime);
        timerSeekerBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("numbers in bar", String.valueOf(progress));

                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

}