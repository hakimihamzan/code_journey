package com.example.instragramclone;

// NICK

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Boolean signUpModeActive = true;
    TextView loginTextView;


    public void signUpClicked(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

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
        loginTextView.setOnClickListener(this);




    
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
        }
    }
}