package com.k31.multipleacitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String[] names = {"Kimi", "Ley", "Amir", "Idjiots"};

    public void goToNext(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

        intent.putExtra("age", 28);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                String value = String.valueOf(adapter.getItem(i));
                intent.putExtra("name", value);
                startActivity(intent);

            }
        });
    }
}