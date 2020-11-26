package com.k31.uglybraintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button0;
    Button button3;
    Button button2;
    TextView scoreTextView;
    TextView timerTextView;
    TextView questionsView;
    TextView resultTextView;
    Button hideGoButton;
    Button playAgainButton;
    ConstraintLayout gameLayout;
    // nick's code
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    public void chooseAnswer(View view) {
       if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
           //Log.i("Correct", "you got it");
           resultTextView.setText("Correct");
           score++;
       } else {
           //Log.i("wrong", "try again");
           resultTextView.setText("Wrong :(");
       }
        numberOfQuestions++;
       scoreTextView.setText(Integer.toString(score) +"/"+ Integer.toString(numberOfQuestions));
       newQuestion();

    }


    public void gameStart(View view) {
        //hide go button
        hideGoButton.setVisibility(View.INVISIBLE);
        playAgain(timerTextView);
        gameLayout.setVisibility(View.VISIBLE);


        //start game
//        button1.setVisibility(View.VISIBLE);
//        button0.setVisibility(View.VISIBLE);
//        button3.setVisibility(View.VISIBLE);
//        button2.setVisibility(View.VISIBLE);
//        scoreTextView.setVisibility(View.VISIBLE);
//        timerTextView.setVisibility(View.VISIBLE);
//        questionsView.setVisibility(View.VISIBLE);
//        resultTextView.setVisibility(View.VISIBLE);



    }

    public void newQuestion() {
        //nick's code
        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        questionsView.setText(Integer.toString(a) + "+" + Integer.toString(b));

        locationOfCorrectAnswer = random.nextInt(4);

        answers.clear();

        for (int i = 0; i<4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a+b);

            } else {
                int wrongAnswer = random.nextInt(41);

                while (wrongAnswer == a+b) {
                    wrongAnswer = random.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void playAgain(View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score) +"/"+ Integer.toString(numberOfQuestions));
        newQuestion();
        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");


        new CountDownTimer(10100, 1000) {

            public void onTick(long millisecondsUntilDone){
                //Log.i("seconds left", String.valueOf(millisecondsUntilDone/1000));
//                if (millisecondsUntilDone/1000 == 0) {
//                    timerTextView.setText("---");
//                } else {
                timerTextView.setText(String.valueOf((millisecondsUntilDone / 1000)) +"s");
//                }

            }

            public void onFinish(){
                //Log.i("we're done", "no more countdown");
                playAgainButton.setVisibility(View.VISIBLE);
                resultTextView.setText("Done");
            }
        }.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.topRightChoice);
        button0 = findViewById(R.id.topLeftChoice);
        button3 = findViewById(R.id.bottomRightChoice);
        button2 = findViewById(R.id.bottomLeftChoice);
        scoreTextView = findViewById(R.id.answerRightView);
        timerTextView = findViewById(R.id.secondsLeftView);
        questionsView = findViewById(R.id.questionsView);
        resultTextView = findViewById(R.id.rightOrWrongTextView);
        hideGoButton = findViewById(R.id.goButton);
        playAgainButton = findViewById(R.id.playAgainButton);
        gameLayout = findViewById(R.id.bottomConstraintLayout);

        hideGoButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);









    }
}