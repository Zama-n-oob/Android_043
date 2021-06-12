package com.example.projeccx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterSeller extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private EditText shop;
    private EditText address;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register_seller );

        EditText firstName = findViewById( R.id.firstname);
        EditText lastName = findViewById( R.id.lastname);
        EditText email = findViewById( R.id.email);
        EditText password = findViewById( R.id.password );
        EditText shop = findViewById( R.id.shop );
        EditText address = findViewById( R.id.address );
        Button register = findViewById( R.id.register );
    }
}