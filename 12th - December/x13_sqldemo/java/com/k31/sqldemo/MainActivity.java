package com.k31.sqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
        //create table users
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS theNewUsers (name VARVCHAR, age INT(3), id INTEGER PRIMARY KEY) ");
        //insert into the row values
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Fido', 48)");
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Sarah', 14)");
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Kimi', 17)");
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Kimi', 27)");
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Kimi', 37)");
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Ley', 23)");
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Pa', 58)");
//        myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Ma', 60)");

        // delete from row
        //myDatabase.execSQL("delete from users where name = 'Nick'");
        myDatabase.execSQL("delete from theNewUsers where id = 4");


        // take somethin out
        //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name != 'Nick' AND age >15", null);
        //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'N%'", null); // starts with nick
        //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%i%' LIMIT 1" , null); // name contain i
        Cursor c = myDatabase.rawQuery("SELECT * FROM theNewUsers" , null); // name contain a

        // get index to access
        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");
        int idIndex = c.getColumnIndex("id");


        // move to top to process
        c.moveToFirst();


        while (!c.isAfterLast()) {
            Log.i("name", c.getString(nameIndex));
            Log.i("age", c.getString(ageIndex));
            Log.i("id", c.getString(idIndex));


            c.moveToNext();
        }

        c.close();

    }
}