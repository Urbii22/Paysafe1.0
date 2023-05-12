package com.example.example.ui.receive;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.example.R;
import com.example.example.databinding.FragmentReceiveBinding;
import com.example.example.ui.pay.CustomAdapter;
import com.example.example.ui.pay.PayVerify;

public class ReceiveFragment extends Fragment {

    private FragmentReceiveBinding binding;

    String selected_method;
    Spinner methods;
    Button btn_pagar;
    EditText edt_pagador, edt_cantidad;
    String[] pay_methods = {"PayPal", "Cuenta bancaria", "MasterCard"};
    int images[] = {R.drawable.paypal, R.drawable.cuentabancaria, R.drawable.mastercard};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ReceiveViewModel receiveViewModel =
                new ViewModelProvider(this).get(ReceiveViewModel.class);

        binding = FragmentReceiveBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        edt_pagador = (EditText) root.findViewById(R.id.edt_pagador);
        edt_cantidad = (EditText) root.findViewById(R.id.edt_cantidad_dinero_recibir);
        methods = (Spinner) root.findViewById(R.id.spinner_receive);

        btn_pagar = (Button) root.findViewById(R.id.btn_pagar_receive);
        methods.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_method = pay_methods[position];
                //Toast.makeText(getActivity().getApplication(), pay_methods[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PayVerify.class);
                Integer cantidad = Integer.parseInt(edt_cantidad.getText().toString());
                Integer pagador = Integer.parseInt(edt_pagador.getText().toString());
                boolean cant=false, dest=false;
                if(cantidad<0 || cantidad > 234.45){
                    edt_cantidad.setError("Cantidad no permitida");
                }else{
                    i.putExtra("Cantidad", cantidad.toString());
                    Toast.makeText(getActivity(), cantidad.toString(), Toast.LENGTH_LONG).show();
                    cant=true;
                }
                if(pagador == 123456){
                    i.putExtra("Destinatario",pagador.toString());
                    dest=true;
                }else{
                    edt_pagador.setError("Destinatario no encontrado");
                }
                i.putExtra("metodo", selected_method);

                if(cant == true && dest == true){
                    i.putExtra("mode", "2");
                    startActivity(i);
                }

            }
        });

        CustomAdapter customAdapter=new CustomAdapter(getActivity().getApplicationContext(),images, pay_methods);
        methods.setAdapter(customAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}