package com.k31.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> places = new ArrayList<String>();
    //String[] places = {"Add a new place...."};
    ArrayAdapter arrayAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        places.add("Add a new place..");


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, places);
        listView.setAdapter(arrayAdapter);

        

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (arrayAdapter.getItem(i) == arrayAdapter.getItem(0)) {
                    System.out.println(places+"------------------");
                    // add new place
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);

                    intent.putStringArrayListExtra("places", places);

                    startActivity(intent);

//                    Intent intentMe = new Intent(getApplicationContext(), MapsActivity.class);
//                    String[] myStrings = new String[] {"test", "test2"};
//                    intentMe.putExtra("strings", myStrings);
//                    startActivity(intentMe);


                } else if (arrayAdapter.getItem(i) != arrayAdapter.getItem(0)){
                    // go to the place
                    System.out.println("not first item");
                }
            }
        });

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Intent intent = getIntent();
//        places = intent.getStringArrayListExtra("places");
//        arrayAdapter.notifyDataSetChanged();
//
//    }
}