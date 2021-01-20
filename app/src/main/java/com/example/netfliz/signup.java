package com.example.netfliz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

//import android.widget.Spinner;

public class signup extends AppCompatActivity {

    EditText mEmail, mNumber, mPassword, mrePassword;
    //Spinner spinner;
    Button Signup;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mEmail = findViewById(R.id.email);
        mNumber = findViewById(R.id.number);
        mPassword = findViewById(R.id.password);
        mrePassword = findViewById(R.id.repassword);
        Signup = findViewById(R.id.signup);
        fAuth = FirebaseAuth.getInstance();


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String number = mNumber.getText().toString().trim();
                String password = mPassword.getText().toString();
                String re_password = mrePassword.getText().toString();

                // if (email.trim().equals("") || number.trim().equals("") || password.trim().equals("")) {
                //   Toast toast = Toast.makeText(getApplicationContext(),
                //         "Please enter all the fields",
                //       Toast.LENGTH_SHORT);

                // toast.show();}
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required");
                    return;
                } else if (TextUtils.isEmpty(number)) {
                    mNumber.setError("Number is required");
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required");
                    return;
                } else if (password.compareTo(re_password) != 0) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Password should be same in both the fields",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }



                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), language.class));
                        } else {
                            Toast.makeText(signup.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
