package com.example.example.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.example.example.Pagina_Bienvenida;
import com.example.example.R;
import com.example.example.ui.account.AccountActivity;

public class SettingsActivity extends AppCompatActivity implements
        PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {

    private static final String TITLE_TAG = "settingsActivityTitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings_content, new HeaderFragment())
                    .commit();
        } else {
            setTitle(savedInstanceState.getCharSequence(TITLE_TAG));
        }
        getSupportFragmentManager().addOnBackStackChangedListener(
                () -> {
                    if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                        setTitle(R.string.title_activity_settings);
                    }
                });

        Toolbar myToolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save current activity title so we can set it again after a configuration change
        outState.putCharSequence(TITLE_TAG, getTitle());
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().popBackStackImmediate()) {
            return true;
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller, Preference pref) {
        // Instantiate the new Fragment
        final Bundle args = pref.getExtras();
        final Fragment fragment = getSupportFragmentManager().getFragmentFactory().instantiate(
                getClassLoader(),
                pref.getFragment());
        fragment.setArguments(args);
        fragment.setTargetFragment(caller, 0);

        Log.i("TEST", pref.getFragment());

        if (pref.getFragment().equals("com.example.example.ui.settings.SettingsActivity$LogoutFragment")) {
            // Impedir que el usuario pueda volver hacia atrás al cerrar la sesión
            Intent intent = new Intent(SettingsActivity.this, Pagina_Bienvenida.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        // Replace the existing Fragment with the new Fragment
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.settings_content, fragment)
                .addToBackStack(null)
                .commit();
        setTitle(pref.getTitle());
        return true;
    }

    public static class HeaderFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.header_preferences, rootKey);
        }
    }

    public static class MessagesFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.messages_preferences, rootKey);
        }
    }

    public static class SyncFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.sync_preferences, rootKey);
        }
    }

    public static class NotificationFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.notification_preferences, rootKey);
        }
    }

    public static class PrivacySecurityFragment extends PreferenceFragmentCompat {

        SwitchPreferenceCompat switchA, switchB, switchC;

        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.privacy_security_preferences, rootKey);

            // Find switches
            switchA = findPreference("use_biometrics");
            switchB = findPreference("payment_confirmation");
            switchC = findPreference("payment_confirmation_with_biometrics");

            // Setup listener
            switchA.setOnPreferenceChangeListener((preference, newValue) -> {
                updateSwitchCSummary((Boolean) newValue, switchB.isChecked());
                return true;
            });

            switchB.setOnPreferenceChangeListener((preference, newValue) -> {
                updateSwitchCSummary(switchA.isChecked(), (Boolean) newValue);
                return true;
            });

            // First time (to remember the state)
            updateSwitchCSummary(switchA.isChecked(), switchB.isChecked());
        }

        private void updateSwitchCSummary(Boolean valueA, Boolean valueB) {
            boolean switchAValue = valueA;
            boolean switchBValue = valueB;
            String summary;

            if (switchAValue && switchBValue) {
                summary = getString(R.string.payment_confirmation_with_biometrics_summary);
                switchC.setEnabled(true);
            } else {
                summary = "Para habilitar esta opción, habilite tanto 'Usar medidas biométricas' y 'Confirmación de pago'";
                switchC.setChecked(false);
                switchC.setEnabled(false);
            }

            switchC.setSummary(summary);
        }
    }

    public static class AboutFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.about_preferences, rootKey);
        }
    }

    public static class HelpFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.help_preferences, rootKey);
        }
    }

    public static class LogoutFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.header_preferences, rootKey);
        }
    }
}