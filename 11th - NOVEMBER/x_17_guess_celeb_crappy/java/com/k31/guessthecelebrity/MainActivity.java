package com.k31.guessthecelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    boolean correct = true;
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> imageUrl = new ArrayList<String>();

    public class DownloadTask extends AsyncTask<String, Void, String> {


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
                Pattern p = Pattern.compile("<div class=\"image\">\n" +
                        "\t\t\t\t\t\t<img src=\"(.*?)\" alt=\"");
                Matcher m = p.matcher(result);

                while (m.find()) {
                    //System.out.println(m.group(1));
                    imageUrl.add(m.group(1));
                    //Log.i("Image source ---", m.group(1));
                }

                p = Pattern.compile("\" alt=\"(.*?)\"/>");
                m = p.matcher(result);

                while (m.find()) {
                    //System.out.println(m.group(1));
                    name.add(m.group(1));
                    //Log.i("Name is ---", m.group(1));

                }


                for (int i = 0; i<name.size(); i++) {
                    Log.i("Name is--------", name.get(i));
                    Log.i("Image URL is--------", imageUrl.get(i));
                }


                return "done";


            } catch (Exception e) {
                e.printStackTrace();
                return "Failed";
            }

        }
    }


    public void chooseCeleb(View view) {
        Log.i("tapped", "here");

        if (correct) {
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong :((", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        String result = null;

        try {
            result = task.execute("https://web.archive.org/web/20190119082828/www.posh24.se/kandisar").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("Result is------------", result);
    }
}


//    String html = "<img alt=\"Keanu Reeves\"height=\"209\" src=\"https://m.media-amazon.com/images/M/MV5BNjUxNDcwMTg4Ml5BMl5BanBnXkFtZTcwMjU4NDYyOA@@._V1_UY209_CR10,0,140,209_AL_.jpg\"width=\"140\" />";
//
//    String river = "MississippiMississippiMississippi";
//
//    Pattern p = Pattern.compile("<img alt=\"(http.*?)\"height=\"209\" src=\"");
//    Matcher m = p.matcher(html);
//
//                while (m.find()) {
//                System.out.println(m.group(1));
//                }
//
//                p = Pattern.compile("\"height=\"209\" src=\"(.*?)\"width=\"140\" />");
//                m = p.matcher(html);
//
//                while (m.find()) {
//                System.out.println(m.group(1));
//                }