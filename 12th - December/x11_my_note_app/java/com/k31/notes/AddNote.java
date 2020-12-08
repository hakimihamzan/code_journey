package com.k31.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import static com.k31.notes.MainActivity.arrayAdapter;
import static com.k31.notes.MainActivity.notePosition;
import static com.k31.notes.MainActivity.notes;
import static com.k31.notes.MainActivity.sharedPreferences;

public class AddNote extends AppCompatActivity {
    String note;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editText = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        note = intent.getStringExtra("note");



        editText.setText(note);
    }

    @Override
    public void onBackPressed() {
        //add note and save to shared preferences
        if (note == null) {
            //System.out.println("note---------------------------nulllllllllllllll" + note);
            String result = editText.getText().toString();
            System.out.println(result);
            notes.add(result);
            arrayAdapter.notifyDataSetChanged();

            sharedPreferences.edit().remove("note");
            try {
                sharedPreferences.edit().putString("note", ObjectSerializer.serialize(notes)).apply();
            } catch (Exception e) {
                e.printStackTrace();
            }

        //add note and save to shared preferences
        } else {
            //System.out.println("note---------------------------notttttttxxxxxxxxxxxxxxxxxxxxxx" + note);
            //update note
            String result = editText.getText().toString();
            System.out.println(result);
            System.out.println(notePosition);
            notes.set(notePosition, result);
            arrayAdapter.notifyDataSetChanged();

            sharedPreferences.edit().remove("note");
            try {
                sharedPreferences.edit().putString("note", ObjectSerializer.serialize(notes)).apply();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        super.onBackPressed();

    }
}