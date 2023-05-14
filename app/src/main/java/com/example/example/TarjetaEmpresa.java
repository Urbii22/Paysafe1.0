package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TarjetaEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_empresa);
        Button Aceptar = (Button) findViewById(R.id.Aceptar);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton Regresar = (ImageButton) findViewById(R.id.RegresarTarjeta);
        Aceptar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(TarjetaEmpresa.this, VerificarUsuarioEmpresa.class));
            }
        });
        Regresar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(TarjetaEmpresa.this, ElegirCobro.class));
            }
        });
    }
}