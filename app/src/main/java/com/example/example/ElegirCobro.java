package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ElegirCobro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_cobro);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton Regresar = (ImageButton) findViewById(R.id.RegresarCobro);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button Tarjeta = (Button) findViewById(R.id.Tarjeta);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button Wallet = (Button) findViewById(R.id.Wallet);
        Regresar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(ElegirCobro.this, MetodosCobro.class));
            }
        });
        Tarjeta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(ElegirCobro.this, TarjetaEmpresa.class));
            }
        });
        Wallet.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(ElegirCobro.this, MetodosCobro.class));
            }
        });
    }
}