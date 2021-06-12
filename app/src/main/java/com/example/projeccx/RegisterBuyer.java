package com.example.projeccx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterBuyer extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register_buyer );

        EditText firstName = findViewById( R.id.firstname);
        EditText lastName = findViewById( R.id.lastname);
        EditText email = findViewById( R.id.email);
        EditText password = findViewById( R.id.password );
        Button register = findViewById( R.id.register);
    }
}