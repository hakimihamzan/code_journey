package com.k31.sqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
        //create table users
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARVCHAR, age INT(3)) ");
        //insert into the row values
        //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Nick', 28)");
        //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Kimi', 27)");


        // take somethin out
        Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

        // get index to access
        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");


        // move to top to process
        c.moveToFirst();


        while (!c.isAfterLast()) {
            Log.i("name", c.getString(nameIndex));
            Log.i("age", c.getString(ageIndex));

            c.moveToNext();
        }


//        SQLiteDatabase myEventDB = this.openOrCreateDatabase("events", MODE_PRIVATE, null);
//        myEventDB.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");
//
//        myEventDB.execSQL("INSERT INTO events (name, year) VALUES ('Convovation', 2019)");
//        myEventDB.execSQL("INSERT INTO events (name, year) VALUES ('COVID party', 2020)");
//        myEventDB.execSQL("INSERT INTO events (name, year) VALUES ('House warming party', 2021)");
//
//        Cursor c = myEventDB.rawQuery("SELECT * FROM events", null);
//
//        c.moveToFirst();
//
//        int nameIndex = c.getColumnIndex("name");
//        int yearIndex = c.getColumnIndex("year");
//
//        while (!c.isAfterLast()) {
//            Log.i("name-------", c.getString(nameIndex));
//            Log.i("year-------", c.getString(yearIndex));
//
//            c.moveToNext();
//        }
//
//        //after use close cursor
//        c.close();



    }
}