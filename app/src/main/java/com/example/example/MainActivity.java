package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b= (Button) findViewById(R.id.button);

        EditText username = (EditText) findViewById(R.id.editTextTextPersonName);
        TextView error = (TextView) findViewById(R.id.textView5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("Pepe")) {
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                }else {
                    error.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    }
