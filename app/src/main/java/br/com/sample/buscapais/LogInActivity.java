package br.com.sample.buscapais;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import br.com.sample.buscapais.util.Constants;

public class LogInActivity extends AppCompatActivity {

    private TextInputLayout mEmail;
    private TextInputLayout mPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initViews();
    }

    private void initViews() {
        mEmail = findViewById(R.id.input_login);
        mPass = findViewById(R.id.input_password);
    }

    public void onClick(View view) {
        if (checkFiels()) {
            if (getDataInPreferences()) {
                startActivity(new Intent(this, ContinentsActivity.class));
            }
        }
    }

    private boolean checkFiels() {
        boolean result = true;

        mEmail.setError(null);
        mPass.setError(null);

        if (TextUtils.isEmpty(mEmail.getEditText().getText().toString())) {
            mEmail.setError(getString(R.string.campo_obrigatorio));

            result = false;
        }

        if (TextUtils.isEmpty(mPass.getEditText().getText().toString())) {
            mPass.setError(getString(R.string.campo_obrigatorio));

            result = false;
        }

        return result;
    }

    private boolean getDataInPreferences() {
        SharedPreferences preferences = getSharedPreferences(Constants.PREF, MODE_PRIVATE);
        String email = preferences.getString(Constants.EMAIL, "");
        String pass = preferences.getString(Constants.PASS, "");

        return confirmLogIn(email, pass);
    }

    private boolean confirmLogIn(String email, String pass) {
        boolean result = true;

        mEmail.setError(null);
        mPass.setError(null);

        if (mEmail.getEditText().getText().toString().equals(email)) {
            if (mPass.getEditText().getText().toString().equals(pass)) {
                startActivity(new Intent(this, ContinentsActivity.class));
                finish();
            } else {
                mPass.setError(getString(R.string.senha_incorreta));
                result = false;
            }
        } else {
            mEmail.setError(getString(R.string.email_incorreto));
            result = false;
        }

        return result;
    }


}
