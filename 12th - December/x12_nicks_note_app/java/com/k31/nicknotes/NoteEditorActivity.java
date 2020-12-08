package com.k31.nicknotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

import static com.k31.nicknotes.MainActivity.arrayAdapter;
import static com.k31.nicknotes.MainActivity.notes;

public class NoteEditorActivity extends AppCompatActivity {
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = findViewById(R.id.editText);
        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        System.out.println("-----------------------------------number---------"+noteId);
        System.out.println("---------------list--------------"+notes);

        if (noteId != -1) {
            editText.setText(MainActivity.notes.get(noteId));
        } else {
            notes.add("");
            noteId = notes.size() - 1;
        }



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                notes.set(noteId, String.valueOf(charSequence));
                arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.k31.nicknotes", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}