package com.example.example.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.example.R;
import com.example.example.databinding.CustomCardViewBinding;
import com.example.example.databinding.FragmentHistoryBinding;

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private com.example.example.databinding.HistoryContentBinding contentBinding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        contentBinding = binding.historyContent;

        setupCardView(contentBinding.exampleCard1, R.string.c1_title, R.string.c1_amount, R.drawable.ic_shopping_cart,
                R.string.c1_from, R.string.c1_to, R.string.c1_date, R.string.c1_method, R.string.c1_id, R.string.c1_desc);
        setupCardView(contentBinding.exampleCard2, R.string.c2_title, R.string.c2_amount, R.drawable.ic_shopping_cart,
                R.string.c2_from, R.string.c2_to, R.string.c2_date, R.string.c2_method, R.string.c2_id, R.string.c2_desc);
        setupCardView(contentBinding.exampleCard3, R.string.c3_title, R.string.c3_amount, R.drawable.ic_receipt,
                R.string.c3_from, R.string.c3_to, R.string.c3_date, R.string.c3_method, R.string.c3_id, R.string.c3_desc);

        return root;
    }

    private void setupCardView(CustomCardViewBinding cardView, int titleResource, int amountResource, int iconResource,
                               int fromResource, int toResource, int dateResource, int methodResource, int idResource,
                               int descriptionResource) {

        final boolean[] isExpanded = {false};

        // Get references to views in the layout
        CardView expandableCardView = cardView.expandableCardView;
        ImageView expandButton = cardView.cardExpandButton;
        ConstraintLayout expandedContent = cardView.cardExpandedContent;

        // Basic info
        TextView cardTitle = cardView.cardTitle;
        TextView cardAmount = cardView.cardAmount;
        ImageView cardIcon = cardView.cardIcon;

        // Extra info
        TextView cardFrom = cardView.cardFrom;
        TextView cardTo = cardView.cardTo;
        TextView cardDate = cardView.cardDate;
        TextView cardMethod = cardView.cardMethod;
        TextView cardId = cardView.cardId;
        TextView cardDesc = cardView.cardDescription;

        // Set up card elements
        cardTitle.setText(getString(titleResource));
        cardAmount.setText(getString(amountResource));
        cardIcon.setImageResource(iconResource);

        cardFrom.setText(getString(fromResource));
        cardTo.setText(getString(toResource));
        cardMethod.setText(getString(methodResource));
        cardId.setText(getString(idResource));
        cardDesc.setText(getString(descriptionResource));
        cardDate.setText(getString(dateResource));

        // Set up click listener for expand button
        expandButton.setOnClickListener(v -> {
            isExpanded[0] = !isExpanded[0];

            if (isExpanded[0]) {
                expandedContent.setVisibility(View.VISIBLE);
                expandButton.setImageResource(R.drawable.ic_collapse_button);
            } else {
                expandedContent.setVisibility(View.GONE);
                expandButton.setImageResource(R.drawable.ic_expand_button);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}