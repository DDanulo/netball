package com.example.robostudent.netball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

public class ForumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFEB39'>Netball</font>"));


        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.ic_action_vector_1);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tobibl:
                Intent inbibl = new Intent(ForumActivity.this, LibrActivity.class);
                startActivity(inbibl);
                break;
            case R.id.tocal:
                Intent incalen = new Intent(ForumActivity.this, CalendarActivity.class);
                startActivity(incalen);
                break;
            case R.id.tochat:
                Intent inforum = new Intent(ForumActivity.this, ForumActivity.class);
                startActivity(inforum);
            case R.id.tonews:
                Intent incomp = new Intent(ForumActivity.this, CompetitionActivity.class);
                startActivity(incomp);

        }
        return super.onOptionsItemSelected(item);
    }
}
