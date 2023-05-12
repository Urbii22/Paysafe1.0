package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_empresa);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton MetodoCobro = (ImageButton) findViewById(R.id.MetodoCobro);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton CuentaEmpresa = (ImageButton) findViewById(R.id.CuentaEmpresa);
        Button Recibir = (Button) findViewById(R.id.RecibirEmpresa);
        MetodoCobro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MenuEmpresa.this, MetodosCobro.class));
            }
        });

        CuentaEmpresa.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MenuEmpresa.this, MetodosCobro.class));
            }
        });
        Recibir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MenuEmpresa.this, MetodosCobro.class));
            }
        });
    }


}