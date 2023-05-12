package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class VerificarUsuarioEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_usuario_empresa);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button Verificar = (Button) findViewById(R.id.Verificar);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton Regresar = (ImageButton) findViewById(R.id.RegresarVerificar);
        Verificar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(VerificarUsuarioEmpresa.this, VerificarUsuarioEmpresa.class));
            }
        });
        Regresar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(VerificarUsuarioEmpresa.this, TarjetaEmpresa.class));
            }
        });
    }
}