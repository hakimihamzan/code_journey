package com.k31.guessthecelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    boolean correct = true;
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> imageUrl = new ArrayList<String>();
    Random random = new Random();
    ImageView imageView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    int a;
    ArrayList<String> answers = new ArrayList<String>();
    String trueAnswer = "";
    ArrayList<String> tempForNameandUrl = new ArrayList<String>();



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


                for (int i = 0; i < name.size(); i++) {
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

    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);


                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(in);

                return myBitmap;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }


    public void chooseCeleb(View view) {

        //check if right or wrong then call again getBitmap


        checkAnswer(view);


        a = random.nextInt(name.size());
        getBitmap(imageView, a);







    }

    private void checkAnswer(View view) {
        if (name.get(a) == view.getTag()) {
            Log.i("xxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxx");
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        }

        if (name.get(a) != view.getTag()) {
            Log.i("wrong", "wrong-------------");
            Toast.makeText(getApplicationContext(), "Wrong :((", Toast.LENGTH_SHORT).show();


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView4);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        DownloadTask task = new DownloadTask();
        String result = null;

        try {
            result = task.execute("https://web.archive.org/web/20190119082828/www.posh24.se/kandisar").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        a = random.nextInt(name.size());


        getBitmap(imageView, a);
        trueAnswer = name.get(a);
    }

    public void getBitmap(ImageView imageView, int a) {
        DownloadImage downloadImage = new DownloadImage();
        Bitmap image = null;

        try {
            image = downloadImage.execute(imageUrl.get(a)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tempForNameandUrl.add(imageUrl.get(a));
        tempForNameandUrl.add(name.get(a));

        imageView.setImageBitmap(image);

        int locationCorrect = random.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationCorrect) {
                answers.add(name.get(a));

            } else {
                int wrongAnswer = random.nextInt(name.size());

                while (name.get(wrongAnswer) == name.get(a)) {

                }
                answers.add(name.get(wrongAnswer));

            }
        }

        button0.setText(answers.get(0));
        button0.setTag(answers.get(0));
        button1.setText(answers.get(1));
        button1.setTag(answers.get(1));
        button2.setText(answers.get(2));
        button2.setTag(answers.get(2));
        button3.setText(answers.get(3));
        button3.setTag(answers.get(3));


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