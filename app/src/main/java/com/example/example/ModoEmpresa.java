package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

public class ModoEmpresa extends AppCompatActivity {
    public void EscribirFichero(){ //deberia ser para la parte del registro

        EditText username = (EditText) findViewById(R.id.usuario);
        EditText password = (EditText) findViewById(R.id.contraseña1);

        String nombreArchivo = "miarchivo2.txt";
        String contenido;

        try {
            FileOutputStream outputStream;

            // Comprobamos si el archivo ya existe
            File archivo = new File(getFilesDir(), nombreArchivo);
            if (archivo.exists()) {
                outputStream = openFileOutput(nombreArchivo, Context.MODE_PRIVATE | Context.MODE_APPEND);
            } else {
                outputStream = openFileOutput(nombreArchivo, Context.MODE_PRIVATE);
            }
            if (username.getText().toString().equals("") || password.getText().toString().equals("")){
                return;
            }
            contenido = username.getText().toString() + " ! " + password.getText().toString() + "\n";
            // Escribimos los datos en el archivo
            if (username.getText().toString().equals("") || password.getText().toString().equals("")){

            }else {
                outputStream.write(contenido.getBytes());
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_empresa);
        Button bRegistro = (Button) findViewById(R.id.b_registro);
        Button bEmpresa = (Button) findViewById(R.id.b_empresa);

        bRegistro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EscribirFichero();
                startActivity(new Intent(ModoEmpresa.this, MenuBarEmpresa.class));
            }
        });

        bEmpresa.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(ModoEmpresa.this,Registro.class));
            }
        });
    }
}