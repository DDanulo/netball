package com.example.robostudent.netball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class CompetitionActivity extends AppCompatActivity {

    Button novunu;
    Button announse;
    Button streams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFEB39'>Netball</font>"));


        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.ic_action_vector_1);

        novunu = (Button) findViewById(R.id.news);
        announse = (Button) findViewById(R.id.anons);
        streams = (Button) findViewById(R.id.transl);

        announse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inAnnouse = new Intent(CompetitionActivity.this, AnnounsmentsActivity.class);
                startActivity(inAnnouse);
            }
        });

        streams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inStreams = new Intent (CompetitionActivity.this, AnnounsmentsActivity.class);
                startActivity(inStreams);
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
                Intent inbibl = new Intent(CompetitionActivity.this, LibrActivity.class);
                startActivity(inbibl);
                break;
            case R.id.tocal:
                Intent incalen = new Intent(CompetitionActivity.this, CalendarActivity.class);
                startActivity(incalen);
                break;
            case R.id.tochat:
                Intent inforum = new Intent(CompetitionActivity.this, ForumActivity.class);
                startActivity(inforum);
            case R.id.tonews:
                Intent incomp = new Intent(CompetitionActivity.this, CompetitionActivity.class);
                startActivity(incomp);

        }
        return super.onOptionsItemSelected(item);
    }


}
