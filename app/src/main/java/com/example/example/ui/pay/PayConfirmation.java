package com.example.example.ui.pay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.example.R;

import org.w3c.dom.Text;

public class PayConfirmation extends AppCompatActivity {

    TextView tv_cantidad, tv_metodo, tv_destinatario, tv_info, tv_cantidadQ, tv_destinatarioQ, tv_desea;
    ImageView imageView;
    Button btn_si, btn_no, btn_volver;
    ConstraintLayout layout_Conf, layout_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_confirmation);

        String cantidad, destinatario, metodo;

        Intent intent = getIntent();
        int mode = Integer.parseInt(intent.getStringExtra("mode"));
        cantidad = intent.getStringExtra("Cantidad");
        destinatario = intent.getStringExtra("Destinatario");
        metodo = intent.getStringExtra("metodo");

        tv_cantidad = (TextView) findViewById(R.id.tv_cantidad);
        tv_cantidadQ = (TextView) findViewById(R.id.tv_cantidadQ);
        tv_metodo = (TextView) findViewById(R.id.tv_metodo);
        tv_destinatario = (TextView) findViewById(R.id.tv_destinatario_resumen);
        tv_destinatarioQ = (TextView) findViewById(R.id.tv_destinatarioQ);
        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_desea = (TextView) findViewById(R.id.tv_desea);

        btn_si = (Button) findViewById(R.id.btn_si);
        btn_no = (Button) findViewById(R.id.btn_no);
        btn_volver = (Button) findViewById(R.id.btn_volver);


        layout_Conf = (ConstraintLayout) findViewById(R.id.consLay_conf);
        layout_finish = (ConstraintLayout) findViewById(R.id.consLay_finish);
        layout_Conf.setVisibility(View.VISIBLE);
        layout_finish.setVisibility(View.INVISIBLE);

        imageView = (ImageView) findViewById(R.id.imageView5);

        if(mode == 2){
            tv_destinatarioQ.setText("PAGADOR");
            tv_cantidadQ.setText("CANTIDAD A SOLICITAR");
            tv_desea.setText("¿DESEA HACER LA PETICIÓN?");
        }else{
            tv_destinatarioQ.setText("DESTINATARIO");
            tv_cantidadQ.setText("CANTIDAD A TRANSFERIR");
            tv_desea.setText("¿DESEA HACER EL PAGO?");
        }
        btn_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.confirmacion, getApplicationContext().getTheme()));
                layout_Conf.setVisibility(View.INVISIBLE);
                layout_finish.setVisibility(View.VISIBLE);
                if(mode == 1){
                    tv_info.setText("TRANSACCIÓN REALIZADA CON ÉXITO");
                }else tv_info.setText("PETICIÓN REALIZADA CON ÉXITO");
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cancel, getApplicationContext().getTheme()));
                layout_Conf.setVisibility(View.INVISIBLE);
                layout_finish.setVisibility(View.VISIBLE);
                if(mode == 1){
                    tv_info.setText("TRANSACCIÓN CANCELADA");
                }else tv_info.setText("PETICIÓN CANCELADA");
            }
        });
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_cantidad.setText(cantidad + "€");
        tv_metodo.setText(metodo);
        tv_destinatario.setText(destinatario);

    }
}