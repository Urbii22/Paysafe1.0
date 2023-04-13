package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {



    public void EscribirFichero(){ //deberia sr para la parte del registro

        EditText username = (EditText) findViewById(R.id.editTextUssername);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);

        String nombreArchivo = "miarchivo2.txt";
        String contenido ="Diego ! Diego23." +  "\n" ;

        try {
            FileOutputStream outputStream;

            // Comprobamos si el archivo ya existe
            File archivo = new File(getFilesDir(), nombreArchivo);
            if (archivo.exists()) {
                outputStream = openFileOutput(nombreArchivo, Context.MODE_PRIVATE | Context.MODE_APPEND);
            } else {
                outputStream = openFileOutput(nombreArchivo, Context.MODE_PRIVATE);
            }
            contenido = username.getText().toString() + " ! " + password.getText().toString() + "\n";
            // Escribimos los datos en el archivo
            outputStream.write(contenido.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b= (Button) findViewById(R.id.button);
        EditText username = (EditText) findViewById(R.id.editTextUssername);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);
        TextView error = (TextView) findViewById(R.id.textView5);

/*
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("Pepe")) {
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                }else {
                    error.setVisibility(View.VISIBLE);
                }
            }
        });*/
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EscribirFichero();
                LeerFichero();
            }
        });

    }

    public void LeerFichero(){
        String nombreArchivo = "miarchivo2.txt";

        try {
            FileInputStream inputStream = openFileInput(nombreArchivo);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                stringBuilder.append(linea).append("\n");
            }

            inputStream.close();
            String contenido = stringBuilder.toString();
            System.out.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
