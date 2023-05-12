package com.example.example.ui.pay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.example.R;

public class PayVerify extends AppCompatActivity {

    EditText edt_codigo;

    Button btn_validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_verify);

        edt_codigo = (EditText) findViewById(R.id.edt_codigo);
        btn_validar = (Button) findViewById(R.id.btn_verificar_codigo);

        String cantidad, destinatario, metodo;
        int mode;

        Intent intent = getIntent();

        cantidad = intent.getStringExtra("Cantidad");
        destinatario = intent.getStringExtra("Destinatario");
        metodo = intent.getStringExtra("metodo");
        mode = Integer.parseInt(intent.getStringExtra("mode"));

        //Toast.makeText(getApplicationContext(), "Código correcto" + cantidad, Toast.LENGTH_SHORT).show();
        btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(edt_codigo.getText().toString()) == 1111){
                    Toast.makeText(getApplicationContext(), "Código correcto", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), PayConfirmation.class);
                    if(mode == 1){
                        i.putExtra("mode", "1");
                    }else i.putExtra("mode", "2");

                    i.putExtra("Cantidad", cantidad);
                    i.putExtra("Destinatario", destinatario);
                    i.putExtra("metodo", metodo);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Código incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}