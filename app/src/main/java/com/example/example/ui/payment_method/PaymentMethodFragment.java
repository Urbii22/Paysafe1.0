package com.example.example.ui.payment_method;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.example.R;
import com.example.example.databinding.FragmentPaymentMethodBinding;

public class PaymentMethodFragment extends Fragment {

    TextView defMethod, defMethodMail, tvMethod1, tvMethod1Mail, tvMethod2, tvMethod2Mail, tvMethod3, tvMethod3Mail;
    ImageView ic_default_method, ic_method1, ic_method2, ic_method3;
    ConstraintLayout consLay1, consLay2, consLay3;
    EditText edt_default_method, edt_default_method_mail, edt_method1, edt_method1_mail, edt_method2, edt_method2_mail, edt_method3, edt_method3_mail;
    Button btn_add, btn_del;
    private FragmentPaymentMethodBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPaymentMethodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        defMethod = root.findViewById(R.id.tv_def_method);
        defMethodMail = root.findViewById(R.id.tv_def_method_mail);
        tvMethod1 = root.findViewById(R.id.tv_method1);
        tvMethod1Mail = root.findViewById(R.id.tv_method1_mail);
        tvMethod2 = root.findViewById(R.id.tv_method2);
        tvMethod2Mail = root.findViewById(R.id.tv_method2_mail);
        tvMethod3 = root.findViewById(R.id.tv_method3);
        tvMethod3Mail = root.findViewById(R.id.tv_method3_mail);

        ic_default_method = root.findViewById(R.id.ic_edit_default_method);
        ic_method1 = root.findViewById(R.id.ic_method1);
        ic_method2 = root.findViewById(R.id.ic_method2);
        ic_method3 = root.findViewById(R.id.ic_method3);

        edt_default_method = root.findViewById(R.id.edt_def_method);
        edt_default_method_mail = root.findViewById(R.id.edt_def_method_mail);
        edt_method1 = root.findViewById(R.id.edt_method1);
        edt_method1_mail = root.findViewById(R.id.edt_method1_mail);
        edt_method2 = root.findViewById(R.id.edt_method2);
        edt_method2_mail = root.findViewById(R.id.edt_method2_mail);
        edt_method3 = root.findViewById(R.id.edt_method3);
        edt_method3_mail = root.findViewById(R.id.edt_method3_mail);


        edt_default_method.setVisibility(View.GONE); edt_default_method_mail.setVisibility(View.GONE);
        edt_method1.setVisibility(View.GONE); edt_method1_mail.setVisibility(View.GONE);
        edt_method2.setVisibility(View.GONE); edt_method2_mail.setVisibility(View.GONE);
        edt_method3.setVisibility(View.GONE); edt_method3_mail.setVisibility(View.GONE);
        defMethod.setVisibility(View.VISIBLE); defMethodMail.setVisibility(View.VISIBLE);
        tvMethod1.setVisibility(View.VISIBLE); tvMethod1Mail.setVisibility(View.VISIBLE);
        tvMethod2.setVisibility(View.VISIBLE); tvMethod2Mail.setVisibility(View.VISIBLE);
        tvMethod3.setVisibility(View.GONE); tvMethod3Mail.setVisibility(View.GONE);

        consLay1 = root.findViewById(R.id.consLay_method1);
        consLay2 = root.findViewById(R.id.consLay_method2);
        consLay3 = root.findViewById(R.id.consLay_method3);
        consLay3.setVisibility(View.GONE);



        btn_add = root.findViewById(R.id.btn_add_payment);
        btn_del = root.findViewById(R.id.btn_del_payment);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(consLay3.getVisibility() == View.GONE){
                    addMethod(consLay3, tvMethod3, tvMethod3Mail, edt_method3, edt_method3_mail);
                }else if(consLay2.getVisibility() == View.GONE){
                    addMethod(consLay2, tvMethod2, tvMethod2Mail, edt_method2, edt_method2_mail);
                }else if(consLay1.getVisibility() == View.GONE){
                    addMethod(consLay1, tvMethod1, tvMethod1Mail, edt_method1, edt_method1_mail);
                }else Toast.makeText(getActivity(), "No se pueden añadir más métodos de pago", Toast.LENGTH_SHORT).show();

            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(consLay3.getVisibility() == View.VISIBLE){
                    delMethod(consLay3);
                }else if(consLay2.getVisibility() == View.VISIBLE){
                    delMethod(consLay2);
                }else if(consLay1.getVisibility() == View.VISIBLE){
                    delMethod(consLay1);
                }else Toast.makeText(getActivity(), "No se pueden borrar más métodos de pago", Toast.LENGTH_SHORT).show();

            }
        });


       ic_default_method.setOnClickListener(view -> {
            if(edt_default_method.getVisibility() == View.GONE){
                defMethod.setVisibility(View.GONE);
                defMethodMail.setVisibility(View.GONE);
                edt_default_method.setVisibility(View.VISIBLE);
                edt_default_method_mail.setVisibility(View.VISIBLE);
                edt_default_method.setText(defMethod.getText().toString());
                edt_default_method_mail.setText(defMethodMail.getText().toString());
            }else{
                defMethod.setVisibility(View.VISIBLE);
                defMethodMail.setVisibility(View.VISIBLE);
                edt_default_method.setVisibility(View.GONE);
                edt_default_method_mail.setVisibility(View.GONE);
                defMethod.setText(edt_default_method.getText().toString());
                defMethodMail.setText(edt_default_method_mail.getText().toString());
            }
        });

       ic_method1.setOnClickListener(view -> {
           if(edt_method1.getVisibility() == View.GONE){
               tvMethod1.setVisibility(View.GONE);
               tvMethod1Mail.setVisibility(View.GONE);
               edt_method1.setVisibility(View.VISIBLE);
               edt_method1_mail.setVisibility(View.VISIBLE);
               edt_method1.setText(tvMethod1.getText().toString());
               edt_method1_mail.setText(tvMethod1Mail.getText().toString());
           }else{
               edt_method1.setVisibility(View.GONE);
               edt_method1_mail.setVisibility(View.GONE);
               tvMethod1.setVisibility(View.VISIBLE);
               tvMethod1Mail.setVisibility(View.VISIBLE);
               tvMethod1.setText(edt_method1.getText().toString());
               tvMethod1Mail.setText(edt_method1_mail.getText().toString());
           }
       });

        ic_method2.setOnClickListener(view -> {
            if(edt_method2.getVisibility() == View.GONE){
                tvMethod2.setVisibility(View.GONE);
                tvMethod2Mail.setVisibility(View.GONE);
                edt_method2.setVisibility(View.VISIBLE);
                edt_method2_mail.setVisibility(View.VISIBLE);
                edt_method2.setText(tvMethod2.getText().toString());
                edt_method2_mail.setText(tvMethod2Mail.getText().toString());
            }else{
                edt_method2.setVisibility(View.GONE);
                edt_method2_mail.setVisibility(View.GONE);
                tvMethod2.setVisibility(View.VISIBLE);
                tvMethod2Mail.setVisibility(View.VISIBLE);
                tvMethod2.setText(edt_method2.getText().toString());
                tvMethod2Mail.setText(edt_method2_mail.getText().toString());
            }
        });

        ic_method3.setOnClickListener(view -> {
            if(edt_method3.getVisibility() == View.GONE){
                tvMethod3.setVisibility(View.GONE);
                tvMethod3Mail.setVisibility(View.GONE);
                edt_method3.setVisibility(View.VISIBLE);
                edt_method3_mail.setVisibility(View.VISIBLE);
                edt_method3.setText(tvMethod3.getText().toString());
                edt_method3_mail.setText(tvMethod3Mail.getText().toString());
            }else{
                edt_method3.setVisibility(View.GONE);
                edt_method3_mail.setVisibility(View.GONE);
                tvMethod3.setVisibility(View.VISIBLE);
                tvMethod3Mail.setVisibility(View.VISIBLE);
                tvMethod3.setText(edt_method3.getText().toString());
                tvMethod3Mail.setText(edt_method3_mail.getText().toString());
            }
        });

        return root;
    }

    private void addMethod(ConstraintLayout consLay, TextView tv1, TextView tv2, EditText edt1, EditText edt2){
        consLay.setVisibility(View.VISIBLE);
        tv1.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        edt1.setVisibility(View.VISIBLE);
        edt2.setVisibility(View.VISIBLE);
        edt1.setHint("Introduce el nombre");
        edt2.setHint("Introduce datos");
    }

    private void delMethod(ConstraintLayout consLay){
        consLay.setVisibility(View.GONE);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}