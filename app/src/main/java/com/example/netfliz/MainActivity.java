package com.example.netfliz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText mEmail,mPassword;
    TextView msignup;
    Button Signin;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        msignup = findViewById(R.id.signup);
        Signin = findViewById(R.id.signin);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString();


                // if (email.trim().equals("") || number.trim().equals("") || password.trim().equals("")) {
                //   Toast toast = Toast.makeText(getApplicationContext(),
                //         "Please enter all the fields",
                //       Toast.LENGTH_SHORT);

                // toast.show();}
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                else if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Authentication
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openregistration();
            }

            public void openregistration()
            {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }});
    }
}
