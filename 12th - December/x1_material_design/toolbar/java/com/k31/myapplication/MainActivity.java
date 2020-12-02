package com.k31.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //set up the toolbar for the app
        setSupportActionBar(toolbar);

        //get the back button on toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    // load the menu properties that we define in R.menu.menu_main
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // pop up the menu that we create in main menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }


    //do what you need when items selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1_id) {
            Toast.makeText(getApplicationContext(), "item1 clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2_id) {
            Toast.makeText(getApplicationContext(), "item2 clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3_id) {
            Toast.makeText(getApplicationContext(), "item3 clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.search_id) {
            Toast.makeText(getApplicationContext(), "searching...", Toast.LENGTH_LONG).show();
        } else if (id == R.id.cart_id) {
            Toast.makeText(getApplicationContext(), "shopping", Toast.LENGTH_SHORT).show();
        //this is the back button
        } else if (id == android.R.id.home) {
            //close activity
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}