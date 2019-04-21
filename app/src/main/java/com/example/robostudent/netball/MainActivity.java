package com.example.robostudent.netball;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ImageView bibl, zmag, chat, kalendar;
    private DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().show();
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFEB39'>Netball</font>"));


        bibl = (ImageView) findViewById(R.id.libr);
        zmag = (ImageView) findViewById(R.id.competitions);
        chat = (ImageView) findViewById(R.id.forum);
        kalendar = (ImageView) findViewById(R.id.calendar);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.ic_action_vector_1);

        bibl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inbibl = new Intent(MainActivity.this, LibrActivity.class);
                startActivity(inbibl);
            }
        });

        zmag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incomp = new Intent(MainActivity.this, CompetitionActivity.class);
                startActivity(incomp);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inforum = new Intent (MainActivity.this, ForumActivity.class);
                startActivity(inforum);
            }
        });

        kalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incalen = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(incalen);
            }
        });





        drawerLayout = findViewById(R.id.drawerlayout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        int id = menuItem.getItemId();

                        if (id==R.id.toacc) {
                            Intent inacc = new Intent(MainActivity.this, AccountActivity.class );
                            startActivity(inacc);
                        }

                        if (id==R.id.toFAQ) {
                            Intent infaq = new Intent(MainActivity.this,FAQActivity.class);
                            startActivity(infaq);
                        }

                        if (id==R.id.toAutor) {
                            Intent inautor = new Intent(MainActivity.this, AutorisationActivity.class );
                            startActivity(inautor);
                        }

                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }





}
