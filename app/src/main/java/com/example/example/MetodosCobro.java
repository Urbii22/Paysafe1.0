package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MetodosCobro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos_cobro);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton Regresar = (ImageButton) findViewById(R.id.RegresarEmpresa);
        Regresar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MetodosCobro.this, MenuEmpresa.class));
            }
        });

    }
}