package com.k31.whatstheweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {
    String appid = "0904a4b44b3c4862e6408e233684ee5d";
    String result = "";
    EditText editText;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        resultTextView = findViewById(R.id.resultTextView);


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
                return "null";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("weather");
                Log.i("Weather content ---", weatherInfo);

                JSONArray array = new JSONArray(weatherInfo);
                String message = "";

                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonPart = array.getJSONObject(i);

                    String main = jsonPart.getString("main");
                    String description = jsonPart.getString("description");

                    if (!main.equals("") && !description.equals("")) {
                        message += main + ": " + description;
                    }
//                    Log.i("Main", jsonPart.getString("main"));
//                    Log.i("Description", jsonPart.getString("description"));


                }

                if (!message.equals("")) {
                    resultTextView.setText(message);
                }

            } catch (Exception e) {
                e.printStackTrace();
                resultTextView.setText(s);
                Toast.makeText(getApplicationContext(), "Can'f find info", Toast.LENGTH_SHORT).show();

            }


        }
    }


    public void getWeather(View view) {


        DownloadJSON downloadJSON = new DownloadJSON();
        try {

            String encodedCityName = URLEncoder.encode(editText.getText().toString(), "UTF-8");

            result = downloadJSON.execute("http://api.openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=" + appid).get();

        } catch (Exception e) {
            e.printStackTrace();

        }

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

//        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
//                InputMethodManager.HIDE_NOT_ALWAYS);

        inputManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);


    }

}