package com.k31.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;

    public void generateTimeTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j<=300; j++) {
            timesTableContent.add(Integer.toString(j*timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTableListView = (ListView) findViewById(R.id.timesTablesView);
        SeekBar numbersChanged = (SeekBar) findViewById(R.id.seekBar);

        int max = 100;
        int startingPosition = 10;

        numbersChanged.setMax(max);
        numbersChanged.setProgress(startingPosition);

        generateTimeTable(startingPosition);

        numbersChanged.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesTableNumber;

                if (progress<min) {
                    timesTableNumber = min;
                    numbersChanged.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }

                Log.i("number", Integer.toString(timesTableNumber));

                generateTimeTable(timesTableNumber);

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