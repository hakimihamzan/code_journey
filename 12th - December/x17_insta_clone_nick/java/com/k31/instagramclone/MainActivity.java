package com.k31.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------------------------------create object
//    ParseObject score = new ParseObject("Score");
//    score.put("username", "ley");
//    score.put("score", 65);
//    score.saveInBackground(new SaveCallback() {
//      @Override
//      public void done(ParseException e) {
//        if (e == null) {
//          //OK
//          Log.i("success", "we saved the score");
//        } else {
//          e.printStackTrace();
//        }
//      }
//    });


        //---------------------------query object
//    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
//    query.getInBackground("SgfkFKwBHx", new GetCallback<ParseObject>() {
//      @Override
//      public void done(ParseObject object, ParseException e) {
//        System.out.println("some-------------------");
//        if (e == null && object != null) {
//          //OK
//          Log.i("username-----------", object.getString("username"));
//
//          Log.i("score--------------", String.valueOf(object.getInt("score")));
//          System.out.println("some-------------------2");
//
//          //if want to update
//          object.put("score", 85);
//          object.put("username","changePeople KimiNow");
//          object.saveInBackground();
//
//        }
//
//        System.out.println("some-------------------3");
//
//      }
//    });

        //create object
//    ParseObject tweet = new ParseObject("Tweet");
//    tweet.put("username", "peele");
//    tweet.put("ic_num", "same age");
//    tweet.put("tweet", "i love them shite (in key's voice)");
//    tweet.saveInBackground(new SaveCallback() {
//      @Override
//      public void done(ParseException e) {
//        if ( e == null) {
//          System.out.println("----------------------------we saved it");
//        } else {
//          e.printStackTrace();
//        }
//      }
//    });

        //query object
//    ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet"); // name of class
//    query.getInBackground("Ys6HIRYjiR", new GetCallback<ParseObject>() {
//      @Override
//      public void done(ParseObject object, ParseException e) {
//        if (e == null && object != null) {
////          object.put("ic_num", "1960");
////          object.saveInBackground();
//          System.out.println(object.getString("username"));
//          System.out.println(object.getString("ic_num"));
//          System.out.println(object.getString("tweet"));

//        }
//      }
//    });
//-------------------------------new
//      ParseObject tweetToo = new ParseObject("Tweettoo");
//      tweetToo.put("username", "kimimejan");
//      tweetToo.put("tweet", "i like cheese");
//
//      tweetToo.saveInBackground(new SaveCallback() {
//        @Override
//        public void done(ParseException e) {
//          if (e == null) {
//            System.out.println("saved---------------");
//          } else {
//            e.printStackTrace();
//          }
//        }
//      });
//---------------------------------------query
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweettoo"); // name of class
//        query.getInBackground("HCVH90Ok3B", new GetCallback<ParseObject>() {
//            @Override
//            public void done(ParseObject object, ParseException e) {
//                if (e == null && object != null) {
//
//                    object.put("tweet", "we done now-----");
//                    object.saveInBackground();
//                    System.out.println(object.getString("username"));
//
//                    System.out.println(object.getString("tweet"));
//
//                }
//            }
//        });


//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
//        //check particular if query got specific
//        query.whereEqualTo("username","ley");
//        query.setLimit(1);
//
//        // get all
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> objects, ParseException e) {
//                if (e == null) {
//                    if (objects.size() > 0) {
//                        for (ParseObject object: objects) {
//                            Log.i("username----------", object.getString("username"));
//                            Log.i("score----------", Integer.toString(object.getInt("score")));
//
//                        }
//                    }
//                }
//            }
//        });

        //---------------challenge
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
//        query.whereGreaterThanOrEqualTo("score", 70);
//
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> objects, ParseException e) {
//                if (e == null){
//                    if(objects.size()>0) {
//                        for (ParseObject object: objects) {
//                            object.put("score", object.getInt("score") + 20);
//                            object.saveInBackground();
//
//                        }
//                    }
//                }
//            }
//        });

        //-------------user sign up

//        ParseUser user = new ParseUser();
//        user.setUsername("nick");
//        user.setPassword("123456");
//
//        user.signUpInBackground(new SignUpCallback() {
//            @Override
//            public void done(ParseException e) {
//                if ( e == null) {
//                    System.out.println("Sign up OK------------------");
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });

        //-----------------log in user

        ParseUser.logInInBackground("nick", "123456", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    System.out.println("Success--------------logged in");
                } else {
                    e.printStackTrace();
                }
            }
        });

        //----------------check if user logged in
        //ParseUser.logOut();

        if (ParseUser.getCurrentUser() != null) {
            System.out.println("Signed in with--------" + ParseUser.getCurrentUser().getUsername());
        } else {
            System.out.println("You are not signed in");
        }

        // log out
        //ParseUser.logOut();


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}