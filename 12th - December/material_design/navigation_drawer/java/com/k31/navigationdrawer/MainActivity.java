package com.k31.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    // crucial tool bar
    android.support.v7.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    // this is the back button behaviour
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //to set item listener **implements** above
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer,  R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.inbox_id:
                Toast.makeText(getApplicationContext(), "inbox", Toast.LENGTH_SHORT).show();
                break;

            case R.id.starred_id:
                Toast.makeText(getApplicationContext(), "starred", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sent_id:
                Toast.makeText(getApplicationContext(), "sent mail", Toast.LENGTH_SHORT).show();
                break;

            case R.id.draft_id:
                Toast.makeText(getApplicationContext(), "drafts", Toast.LENGTH_SHORT).show();
                break;

            case R.id.allmail_id:
                Toast.makeText(getApplicationContext(), "allmail", Toast.LENGTH_SHORT).show();
                break;

            case R.id.trash_id:
                Toast.makeText(getApplicationContext(), "trash", Toast.LENGTH_SHORT).show();

                break;

            case R.id.spam_id:
                Toast.makeText(getApplicationContext(), "spam", Toast.LENGTH_SHORT).show();

                break;
        }

        // close to the left side
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}