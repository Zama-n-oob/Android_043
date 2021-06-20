package com.example.projeccx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginSeller extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private Button register;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_seller );

        EditText email = findViewById( R.id.email );
        EditText password = findViewById( R.id.password );
        Button login = findViewById( R.id.login);
        Button register = findViewById( R.id.register );

        auth = FirebaseAuth.getInstance();

        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                if (TextUtils.isEmpty( txt_email ) || TextUtils.isEmpty( txt_password ) || TextUtils.isEmpty( txt_email ) || TextUtils.isEmpty( txt_password ) ) {
                    Toast.makeText( LoginSeller.this, "Empty Credentials", Toast.LENGTH_SHORT ).show();
                }  else {
                    loginSeller(txt_email,txt_password);
                }
            }
        } );

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(LoginSeller.this,RegisterSeller.class) );
            }
        } );
    }

    private void loginSeller(String email, String password) {
        auth.signInWithEmailAndPassword( email, password ).addOnSuccessListener( new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText( LoginSeller.this, "Logged in", Toast.LENGTH_SHORT ).show();
                startActivity( new Intent(LoginSeller.this, Homepage1.class) );
                finish();
            }
        } );

        auth.signInWithEmailAndPassword( email, password ).addOnFailureListener( new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText( LoginSeller.this,"Incorrect Email/Password", Toast.LENGTH_SHORT ).show();
            }
        } );
    }
}