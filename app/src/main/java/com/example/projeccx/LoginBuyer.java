package com.example.projeccx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginBuyer extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView noreg;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_buyer );

        EditText email = findViewById( R.id.email );
        EditText password = findViewById( R.id.password );
        Button login = findViewById( R.id.login);
        TextView noreg = findViewById( R.id.noreg );
        Button register = findViewById( R.id.register );

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(LoginBuyer.this,RegisterBuyer.class) );
            }
        } );
    }
}