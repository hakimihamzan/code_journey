package com.k31.checkitout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView descTextView;
    String appid = "0904a4b44b3c4862e6408e233684ee5d";
    String result = "";
    EditText textInput;


    public void printSome(View view) {
        System.out.println(result);
    }

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
                resultHere = "Error";
                descTextView.setText(resultHere);
                return resultHere;
            }

        }

        @Override
        protected void onPostExecute(String resultHere) {
            super.onPostExecute(resultHere);

            try {
                JSONObject jsonObject = new JSONObject(resultHere);

                String weatherInfo = jsonObject.getString("weather");
                //Log.i("Weather content ---", weatherInfo);

                JSONArray array = new JSONArray(weatherInfo);

                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonPart = array.getJSONObject(i);

                    Log.i("Main", jsonPart.getString("main"));
                    Log.i("Description", jsonPart.getString("description"));

                    descTextView.setText("Main: " + jsonPart.getString("main") + "\n" + "Description: " + jsonPart.getString("description"));


                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


    public void checkWeather(View view) {
        String input = String.valueOf(textInput.getText());

        System.out.println(input);
        DownloadJSON downloadJSON = new DownloadJSON();


        try {
            result = downloadJSON.execute("http://api.openweathermap.org/data/2.5/weather?q=" + input + "&appid=" + appid).get();

        } catch (Exception e) {
            e.printStackTrace();
            result = "Error";
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descTextView = findViewById(R.id.descTextView);
        descTextView.setX(-1000);
        descTextView.animate().translationXBy(1000).setDuration(1000);
        textInput = findViewById(R.id.editCityText);

        DownloadJSON downloadJSON = new DownloadJSON();



        try {
            result = downloadJSON.execute("http://api.openweathermap.org/data/2.5/weather?q=London&appid=" + appid).get();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}