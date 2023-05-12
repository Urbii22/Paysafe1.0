package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CobroExito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobro_exito);
        Button Volver = (Button) findViewById(R.id.VolverEmpresa);

        Volver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(CobroExito.this, MetodosCobro.class));
            }
        });
    }
}