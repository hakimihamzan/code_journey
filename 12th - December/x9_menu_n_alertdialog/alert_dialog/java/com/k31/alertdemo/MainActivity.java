package com.k31.alertdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String language = "";
    TextView textView;
    SharedPreferences sharedPreferences;


    // create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // on selected menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.preference) {
            alertDialogNow();
            return true;
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new AlertDialog.Builder(this)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setTitle("Are you sure??!")
//                .setMessage("Do you definitely want to do this?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this, "It'sdone", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton("No", null)
//                .show();

        sharedPreferences = getSharedPreferences("com.k31.alertdemo", Context.MODE_PRIVATE);

        textView = (TextView) findViewById(R.id.textView);
        alertDialogNow();





    }

    public void alertDialogNow() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_menu_preferences)
                .setTitle("Language Preferences")
                .setMessage("Which of the two language do you prefer?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "English selected", Toast.LENGTH_SHORT).show();
                        language = "English";
                        textView.setText("Hello World in English");
                        System.out.println("Language is now --------" + language);
                        sharedPreferences.edit().putString("language", language).apply();


                    }
                })
                .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Spanish selected", Toast.LENGTH_SHORT).show();
                        language = "Spanish";
                        textView.setText("Hola estupidos smirk");
                        System.out.println("Language is now --------" + language);
                        sharedPreferences.edit().putString("language", language).apply();


                    }
                })
                .show();


    }
}