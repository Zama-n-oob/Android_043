package com.example.projeccx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.NotNull;

public class RegisterBuyer extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private Button register;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register_buyer );

        EditText firstName = findViewById( R.id.firstname);
        EditText lastName = findViewById( R.id.lastname);
        EditText email = findViewById( R.id.email);
        EditText password = findViewById( R.id.password );
        Button register = findViewById( R.id.register);
        auth = FirebaseAuth.getInstance();

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_firstName = firstName.getText().toString();
                String txt_lastName = lastName.getText().toString();
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty( txt_firstName ) || TextUtils.isEmpty( txt_lastName ) || TextUtils.isEmpty( txt_email ) || TextUtils.isEmpty( txt_password )) {
                    Toast.makeText( RegisterBuyer.this, "Empty Credentials", Toast.LENGTH_SHORT ).show();
                } else if (txt_password.length()<6){
                    Toast.makeText( RegisterBuyer.this, "Password must consist 6 digits", Toast.LENGTH_SHORT ).show();
                } else {
                    registerUser(txt_email,txt_password);
                }
            }
        } );
    }

    private void registerUser( String email, String password) {
        auth.createUserWithEmailAndPassword( email,password ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText( RegisterBuyer.this, "Registration Successful", Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent(RegisterBuyer.this, LoginBuyer.class) );
                    finish();
                } else {
                    Toast.makeText( RegisterBuyer.this, "Already Registered", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}