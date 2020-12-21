package com.k31.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.k31.cityguide.R;
import com.k31.cityguide.User.UserDashBoard;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER = 3000;

    ImageView backgroundImage;
    TextView poweredByLine;

    //Animations
    Animation sideAnim, bottomAnim;

    //remember user
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //no status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        //Hooks
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.poweredByLine);

        //Animations
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animations on elements
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);

        // splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);

                //onboarding get value of firsttime if not exist then create one, if exist then use that
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true); //

                if (isFirstTime) {

                    // if true then edit value of first time with this code and commit those changes
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.apply();

                    Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(intent);

                    // destroy this splashscreen
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, UserDashBoard.class);
                    startActivity(intent);

                    // destroy this splashscreen
                    finish();
                }

            }
        },SPLASH_TIMER);

    }
}