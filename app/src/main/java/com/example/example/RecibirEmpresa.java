package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RecibirEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_empresa);
        Button Recibir = (Button) findViewById(R.id.RecibirEmpresa);

        Recibir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(RecibirEmpresa.this, MenuEmpresa.class));
            }
        });
    }
}