package com.example.robostudent.netball;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class LibrActivity extends AppCompatActivity {

    ImageView osnovy, pravyla;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibl);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.ic_action_vector_1);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFEB39'>Netball</font>"));


        osnovy = (ImageView) findViewById(R.id.foundaments);
        pravyla = (ImageView) findViewById(R.id.rules);

        osnovy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inosn = new Intent(LibrActivity.this, OsnovyActivity.class);
                startActivity(inosn);
            }
        });

        pravyla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inrules = new Intent(LibrActivity.this, RulesActivity.class);
                startActivity(inrules);
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tobibl:
                Intent inbibl = new Intent(LibrActivity.this, LibrActivity.class);
                startActivity(inbibl);
                break;
            case R.id.tocal:
                Intent incalen = new Intent(LibrActivity.this, CalendarActivity.class);
                startActivity(incalen);
                break;
            case R.id.tochat:
                Intent inforum = new Intent(LibrActivity.this, ForumActivity.class);
                startActivity(inforum);
            case R.id.tonews:
                Intent incomp = new Intent(LibrActivity.this, CompetitionActivity.class);
                startActivity(incomp);

        }
        return super.onOptionsItemSelected(item);
    }
}
