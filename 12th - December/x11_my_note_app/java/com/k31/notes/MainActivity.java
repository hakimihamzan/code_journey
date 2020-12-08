package com.k31.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static ArrayAdapter arrayAdapter;
    static ArrayList<String> notes = new ArrayList<>();
    static int notePosition = 0;
    static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        sharedPreferences = getSharedPreferences("com.k31.notes", Context.MODE_PRIVATE);
        notes.clear();

        try {
            notes = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("note", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("here it is----------------------------------------"+notes);

        if (notes.size()>0) {
            arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, notes);
            listView.setAdapter(arrayAdapter);

        } else if (notes.size()==0) {
            notes.add("Example note");
            arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, notes);
            listView.setAdapter(arrayAdapter);
        }



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "im longggggly clicked", Toast.LENGTH_SHORT).show();
                System.out.println("-------------------"+notes.get(i));
                notePosition = i;


                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_btn_speak_now)
                        .setTitle("Delete note")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                notes.remove(notePosition);
                                System.out.println(notePosition);
                                arrayAdapter.notifyDataSetChanged();

                                sharedPreferences.edit().remove("note");
                                try {
                                    sharedPreferences.edit().putString("note", ObjectSerializer.serialize(notes)).apply();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.out.println(notePosition);

                            }
                        })
                        .show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, "im clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AddNote.class);
                intent.putExtra("note", notes.get(i));
                notePosition = i;
                startActivity(intent);


                //System.out.println("this is int i----------------------"+notes.get(i));
                System.out.println("---------------------------"+notePosition);

            }
        });
    }

















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_notes) {
            Intent intent = new Intent(getApplicationContext(), AddNote.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}