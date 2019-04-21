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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AutorisationActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser user;
    private DatabaseReference reference;
    FirebaseDatabase database;

    EditText etEmail, etPassword, etNic_name;
    Button btAvtoruzacia, btReestrazia;
    String displayName;
    Button btgotochat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorisation);
        getSupportActionBar().show();
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFEB39'>Netball</font>"));

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.ic_action_vector_1);

        etEmail = (EditText) findViewById(R.id.email);
        etPassword = (EditText) findViewById(R.id.password);
        etNic_name = (EditText) findViewById(R.id.nickname);
        btAvtoruzacia = (Button) findViewById(R.id.authorise);
        btReestrazia = (Button) findViewById(R.id.register);
        btgotochat = (Button) findViewById(R.id.goToChat);
        btAvtoruzacia.setOnClickListener(this);
        btReestrazia.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("nic");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                displayName = (String)(dataSnapshot.getValue());
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //метод getCurrentUser() щоб отримати FirebaseUser обєкт, який містить інформацію про зареєстрованого користувача
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Intent intent = new Intent(AutorisationActivity.this, ChatActivity.class);
                    intent.putExtra("logo", displayName);
                    startActivity (intent);
                } else {
                    // User is signed out
                }
            }
        };


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.authorise) {
            signin(etEmail.getText().toString(), etPassword.getText().toString());
            etNic_name.setText (displayName);
        }
        if (v.getId() == R.id.register){
            registration(etEmail.getText().toString(),etPassword.getText().toString(), etNic_name.getText().toString());
        }
        if (v.getId() == R.id.goToChat){
            Intent intent = new Intent(this, ChatActivity.class);
            intent.putExtra("logo", displayName);
            startActivity(intent);
        }

    }
    void signin(String email , String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult> () {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(AutorisationActivity.this, "Aвторизація пройшла успішно", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(AutorisationActivity.this, "Aвторизація провалена", Toast.LENGTH_SHORT).show();

            }
        });
    }

    void registration(String email , String password, String nic) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AutorisationActivity.this, "Реєстрація пройшла успешно", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(AutorisationActivity.this, "Реєстрація провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
