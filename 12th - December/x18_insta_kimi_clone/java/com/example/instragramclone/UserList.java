package com.example.instragramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {

    ArrayList<String> users = new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listView = findViewById(R.id.listView);
        users.add("ley");
        users.add("kimi");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(arrayAdapter);

        if(ParseUser.getCurrentUser() != null) {
            System.out.println("Signed in with--------"+ParseUser.getCurrentUser().getUsername());
        } else {
            System.out.println("----------------------You are not signed in");
        }

        //query for user list

//        ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> objects, ParseException e) {
//                if (e == null) {
//                    if (objects.size()>0) {
//                        for (ParseObject object : objects) {
//                            System.out.println(object.getString("username"));
//                        }
//                    }
//                }
//            }
//        });

    }
}