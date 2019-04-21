package com.example.robostudent.netball;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    ChatAdapter adapter;
    ListView listChat;

    EditText chat;
    Button send;
    TextView nic_name;


    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFEB39'>Netball</font>"));

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.ic_action_vector_1);

        Intent intent = getIntent();
        String logo = intent.getStringExtra("logo");

        send = (Button) findViewById(R.id.send);
        chat = (EditText) findViewById(R.id.chat);
        listChat = (ListView) findViewById(R.id.listChat);
        nic_name = (TextView) findViewById(R.id.nic_name);
        nic_name.setText(logo);

        adapter = new ChatAdapter(getBaseContext(), R.layout.list_massenger);
        listChat.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("chat");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ChatMesage msg = dataSnapshot.getValue(ChatMesage.class);
                adapter.add(msg);
                scrollToBottom();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) { }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatMesage msg = new ChatMesage(nic_name.getText().toString(), chat.getText().toString());
                reference.push().setValue(msg);
                chat.setText("");
                scrollToBottom();
            }
        });
    }

    private void scrollToBottom() {
        listChat.post(new Runnable() {
            @Override
            public void run() {
                listChat.setSelection(adapter.getCount() - 1);
            }
        });
    }
}
