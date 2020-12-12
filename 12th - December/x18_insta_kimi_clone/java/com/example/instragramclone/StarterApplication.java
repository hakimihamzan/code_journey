package com.example.instragramclone;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class StarterApplication extends Application
{
    //// Reference: https://docs.parseplatform.org/android/guide/#the-parseobject

    @Override
    public void onCreate()
    {
        super.onCreate();
    
        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
        
                                 .applicationId("myappID")
                                 // if defined
                                 .clientKey("hzpfYJAXhJM5")

                                 // Add your Server IP Addrses
                                 .server("http://3.22.183.8/parse/") // Add Your Server IP. Do not add "PORT Number" such as ip:80 or ip:1337
                                 .build()
        );




        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    
    }// onCreate()

}// class StarterApplication
