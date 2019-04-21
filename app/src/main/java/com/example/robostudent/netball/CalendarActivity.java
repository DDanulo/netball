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
import android.widget.CalendarView;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    Button toAdd;
    CalendarView calendar;
    TextView date, textEvent;

    public long dateLongMillise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFEB39'>Netball</font>"));

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.ic_action_vector_1);

        calendar = (CalendarView) findViewById(R.id.kalendar);
        date = (TextView) findViewById(R.id.data);
        textEvent = (TextView) findViewById(R.id.eventText);
        toAdd = (Button) findViewById(R.id.toAdd);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                dateLongMillise = view.getDate();
                date.setText(dayOfMonth + "." + (month+1) + "." + year);
            }
        });

        toAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inAdd = new Intent(CalendarActivity.this, EventAddActivity.class);
                startActivity(inAdd);
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
                Intent inbibl = new Intent(CalendarActivity.this, LibrActivity.class);
                startActivity(inbibl);
                break;
            case R.id.tocal:
                Intent incalen = new Intent(CalendarActivity.this, CalendarActivity.class);
                startActivity(incalen);
                break;
            case R.id.tochat:
                Intent inforum = new Intent(CalendarActivity.this, ForumActivity.class);
                startActivity(inforum);
            case R.id.tonews:
                Intent incomp = new Intent(CalendarActivity.this, CompetitionActivity.class);
                startActivity(incomp);

        }
        return super.onOptionsItemSelected(item);
    }




}
