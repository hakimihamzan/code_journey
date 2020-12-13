package com.example.instragramclone;

// NICK

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener
{
    Boolean signUpModeActive = true;
    TextView loginTextView;
    EditText usernameEditText;
    EditText passwordEditText;

    public void showUsersList() {
        Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
        startActivity(intent);
    }


    public void signUpClicked(View view) {

        if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {
            Toast.makeText(this, "Username and password required", Toast.LENGTH_SHORT).show();
        } else {

            if (signUpModeActive) {
                ParseUser user = new ParseUser();
                user.setUsername(usernameEditText.getText().toString());
                user.setPassword(passwordEditText.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            System.out.println("----------------------------success");
                            showUsersList();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show(); // getmessage friendlier
                        }
                    }
                });
            } else {
                ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if ( user != null) {
                            System.out.println("--------------log in ok");
                            showUsersList();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show(); // getmessage friendlier

                        }
                    }
                });
            }

        }

    }

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTextView = (TextView) findViewById(R.id.loginTextView);
        //this was implement up top - method generated is on click
        loginTextView.setOnClickListener(this);


        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        //this was implement up top - method generated is onkey
        passwordEditText.setOnKeyListener(this);

        if (ParseUser.getCurrentUser() != null) {
            showUsersList();
        }

        ImageView logoImageView = findViewById(R.id.logoImageView);
        ConstraintLayout backgroundLayout = findViewById(R.id.background_layout);

        logoImageView.setOnClickListener(this);
        backgroundLayout.setOnClickListener((this));

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginTextView) {
            System.out.println("switch---------------clicked");
            Button signUpButton = findViewById(R.id.signupButton);

            if (signUpModeActive) {
                signUpModeActive = false;
                signUpButton.setText("log in");
                loginTextView.setText("or, Sign up");
            } else {
                signUpModeActive = true;
                signUpButton.setText("sign up");
                loginTextView.setText("or, Log in");
            }
        } else if (v.getId() == R.id.logoImageView || v.getId() == R.id.background_layout) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            signUpClicked(v);
        }

        return false;
    }
}