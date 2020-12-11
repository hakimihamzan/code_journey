package com.k31.newsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> storyId = new ArrayList<>();
    ArrayList<String> newsItem = new ArrayList<String>();
    ArrayList<String> urlItem = new ArrayList<String>();
    ArrayAdapter arrayAdapter;



    public class DownloadJSONStoryID extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;

                    data = reader.read();
                }
                //System.out.println("--------------------"+result);
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(result);
                while(m.find()) {
                    //System.out.println(m.group());
                    storyId.add(m.group());

                }


                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

    }

    public class DownloadJSONStoryDetail extends AsyncTask<String, Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;

                    data = reader.read();
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            try {
//
//                    JSONObject jsonObject = new JSONObject(s);
//                    String title = jsonObject.getString("title");
//                    String url = jsonObject.getString("url");
//
//                    System.out.println("------------------------title"+title);
//                    System.out.println("------------------------url"+url);
//                    newsItem.add(title);
//                    arrayAdapter.notifyDataSetChanged();
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
    }



    public void getStoryIdData() {
        String result = "";
        DownloadJSONStoryID downloadJSON = new DownloadJSONStoryID();
        try {
            result = downloadJSON.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty").get();

        } catch (Exception e) {
            e.printStackTrace();
        }
       // System.out.println(result.charAt(100));
    }

    public void getStoryDetailData(String i) {
        String result = "";
        DownloadJSONStoryDetail downloadJSON = new DownloadJSONStoryDetail();
        try {
//            for (String i: storyId) {
//                result = downloadJSON.execute("https://hacker-news.firebaseio.com/v0/item/"+i+".json?print=pretty").get();
//            }
            result = downloadJSON.execute("https://hacker-news.firebaseio.com/v0/item/"+i+".json?print=pretty").get();
            System.out.println(result);

            try {

                    JSONObject jsonObject = new JSONObject(result);
                    String title = jsonObject.getString("title");
                    String url = jsonObject.getString("url");

                    System.out.println("------------------------title"+title);
                    System.out.println("------------------------url"+url);
                    newsItem.add(title);
                    urlItem.add(url);



            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(result.charAt(20));
        //Log.i("Here's json=-----", result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        getStoryIdData();
        for (int i = 0; i<30; i++) {
            getStoryDetailData(storyId.get(i));
        }

        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, newsItem);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, urlItem.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WebView.class);
                intent.putExtra("url", urlItem.get(i));
                startActivity(intent);

            }
        });
    }
}