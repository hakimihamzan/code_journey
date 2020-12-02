package com.k31.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.RadioButton1:
                        Toast.makeText(MainActivity.this, "button one checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.RadioButton2:
                        Toast.makeText(MainActivity.this, "button two checked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}