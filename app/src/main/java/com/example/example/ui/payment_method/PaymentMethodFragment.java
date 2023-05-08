package com.example.example.ui.payment_method;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.example.databinding.FragmentPaymentMethodBinding;

public class PaymentMethodFragment extends Fragment {

    private FragmentPaymentMethodBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PaymentMethodViewModel paymentMethodViewModel =
                new ViewModelProvider(this).get(PaymentMethodViewModel.class);

        binding = FragmentPaymentMethodBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        paymentMethodViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}