package com.example.netfliz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class language extends AppCompatActivity {

    CheckBox English, Hindi;
    Button Signup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        English = findViewById(R.id.english);
        Hindi = findViewById(R.id.hindi);
        Signup1 = findViewById(R.id.signup1);



        Signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignin();
            }
             public void opensignin()
             {
                 Intent intent = new Intent(language.this, MainActivity.class);
                 startActivity(intent);
            }
        });
    }
}