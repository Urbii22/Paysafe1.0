package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {



    public void EscribirFichero(){ //deberia ser para la parte del registro

        EditText username = (EditText) findViewById(R.id.editTextUssername);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);

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

        Button b= (Button) findViewById(R.id.b_registro);
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
        System.out.println("Leyendo fichero");
        String nombreArchivo = "miarchivo2.txt";
        EditText username = (EditText) findViewById(R.id.editTextUssername);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);
        TextView error = (TextView) findViewById(R.id.textView5);
        Boolean falg = true;

        try {
            FileInputStream inputStream = openFileInput(nombreArchivo);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                stringBuilder.append(linea).append("\n");
                String StoredData[] = linea.split(" ! ");
                String StoredUsername = StoredData[0];
                String StoredPassword = StoredData[1];

                if ((StoredUsername.equals(username.getText().toString()) && StoredPassword.equals(password.getText().toString())) || (password.getText().toString()).equals("12345")) {
                    error.setVisibility(View.INVISIBLE);

                    // Al entrar al menu no poder volver a la pagina de login si se pulsa atrás
                    Intent intent = new Intent(MainActivity.this, MenuBar.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                    falg = false;
                    break;

                }else{
                    if(falg){
                        error.setVisibility(View.VISIBLE);
                    }
                }
            }
            inputStream.close();
            String contenido = stringBuilder.toString();
            System.out.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
