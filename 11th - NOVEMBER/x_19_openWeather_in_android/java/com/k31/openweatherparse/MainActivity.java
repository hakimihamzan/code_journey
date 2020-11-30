package com.k31.openweatherparse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    String appid = "0904a4b44b3c4862e6408e233684ee5d";
    String result = "";
    TextView textView;

    public class DownloadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String resultHere = "";
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
                    resultHere += current;
                    data = reader.read();
                }

                return resultHere;


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("weather");
                //Log.i("Weather content ---", weatherInfo);

                JSONArray array = new JSONArray(weatherInfo);

                for (int i = 0; i<array.length(); i++) {
                    JSONObject jsonPart = array.getJSONObject(i);

                    Log.i("Main", jsonPart.getString("main"));
                    Log.i("Description", jsonPart.getString("description"));


                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        DownloadJSON downloadJSON = new DownloadJSON();

        try {
            result = downloadJSON.execute("http://api.openweathermap.org/data/2.5/weather?q=London&appid=" + appid).get();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Log.i("result it-------", result);
        textView.setText(result);
    }

    public class parsingResult {

    }

}