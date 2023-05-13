package com.example.example.ui.account;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.example.Pagina_Bienvenida;
import com.example.example.R;

import java.util.Locale;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        View accountName = findViewById(R.id.account_name),
             accountBirthday = findViewById(R.id.account_birthday),
             accountEmail = findViewById(R.id.account_email),
             accountPhone = findViewById(R.id.account_phone);

        setupTextViews(accountName, R.string.cat_name, R.string.cat_name_main);
        setupTextViews(accountBirthday, R.string.cat_birthday, R.string.cat_birthday_main);
        setupTextViews(accountEmail, R.string.cat_email, R.string.cat_email_main);
        setupTextViews(accountPhone, R.string.cat_phone, R.string.cat_phone_main);

        setSupportActionBar(findViewById(R.id.account_toolbar));
        setTitle("Cuenta");

        Button logOutButton = findViewById(R.id.logout_button),
               deleteAccountButton = findViewById(R.id.delete_account_button);

        logOutButton.setOnClickListener(view -> {
            // Impedir que el usuario pueda volver hacia atrás al cerrar la sesión
            Intent intent = new Intent(AccountActivity.this, Pagina_Bienvenida.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        deleteAccountButton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("¿Estás seguro?")
                    .setMessage("¿Está seguro de que desea eliminar su cuenta? Este proceso puede durar alrededor de 30 días, durante dicho periodo su " +
                            "cuenta aún será recuperable si contacta con el soporte al usuario. Pasado este periodo su cuenta no será recuperable y los " +
                            "datos serán perdidos. Existe la posibilidad de que mantengamos sus datos por un periodo de tiempo superior por motivos legales.")
                    .setPositiveButton("Eliminar cuenta", (dialogInterface, i) -> {
                        Intent intent = new Intent(AccountActivity.this, Pagina_Bienvenida.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("Cancelar", null)
                    .create()
                    .show();
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupTextViews(View textView, int categoryStringResource, int mainTextDefaultStringResource) {
        TextView category = textView.findViewById(R.id.category_title);
        ImageView rightIcon = textView.findViewById(R.id.right_icon);
        EditText editMainText = textView.findViewById(R.id.edit_main);
        TextView mainText = textView.findViewById(R.id.main_title);

        editMainText.setVisibility(View.GONE);
        mainText.setVisibility(View.VISIBLE);

        category.setText(categoryStringResource);
        mainText.setText(mainTextDefaultStringResource);

        rightIcon.setOnClickListener(view -> {
            if(editMainText.getVisibility() == View.GONE){
                mainText.setVisibility(View.GONE);
                editMainText.setVisibility(View.VISIBLE);
            }else{
                mainText.setVisibility(View.VISIBLE);
                editMainText.setVisibility(View.GONE);
                mainText.setText(editMainText.getText().toString());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}