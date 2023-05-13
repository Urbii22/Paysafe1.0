package com.example.example.ui.pay;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.example.R;
import com.example.example.databinding.FragmentPayBinding;

import org.w3c.dom.Text;

public class PayFragment extends Fragment{

    Button pay;
    EditText edt_cantidad, edt_destinatario;
    String selected_method;
    Spinner methods;
    TextView tv_pay_method;
    String[] pay_methods = {"PayPal", "Cuenta bancaria", "MasterCard"};
    int images[] = {R.drawable.paypal, R.drawable.cuentabancaria, R.drawable.mastercard};
    private FragmentPayBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPayBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        methods = (Spinner) root.findViewById(R.id.spinner);
        pay = (Button) root.findViewById(R.id.btn_pagar);
        edt_cantidad = (EditText) root.findViewById(R.id.edt_cantidad_dinero);
        edt_destinatario = (EditText) root.findViewById(R.id.edt_destinatario);
        tv_pay_method = (TextView) root.findViewById(R.id.tv_metodo_pago);
        methods.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_method = pay_methods[position];
                //Toast.makeText(getActivity().getApplication(), pay_methods[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv_pay_method.setText("Selecciona método pago");
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PayVerify.class);
                String cantidadTemp = edt_cantidad.getText().toString();
                String destinatarioTemp = edt_destinatario.getText().toString();
                Integer cantidad = 0, destinatario = 0;
                boolean cant=false, dest=false;
                try{
                    cantidad = Integer.parseInt(cantidadTemp);
                    //cant = true;
                }catch(NumberFormatException e){
                    edt_cantidad.setError("Introduce un valor correcto");
                }
                try{
                    destinatario = Integer.parseInt(destinatarioTemp);
                    //dest = true;
                }catch (NumberFormatException e){

                    edt_destinatario.setError("Introduce un valor correcto");
                }

                i.putExtra("Cantidad", cantidadTemp);
                i.putExtra("Destinatario", destinatarioTemp);

                if(cantidad<0 || cantidad > 234.45){
                    edt_cantidad.setError("Cantidad no permitida");
                }else{

                    Toast.makeText(getActivity(), cantidad.toString(), Toast.LENGTH_LONG).show();
                    cant=true;
                }
                if(destinatario == 123456){

                    dest=true;
                }else{
                    edt_destinatario.setError("Destinatario no encontrado");
                }
                i.putExtra("metodo", selected_method);

                if(cant == true && dest == true){
                    i.putExtra("mode", "1");
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