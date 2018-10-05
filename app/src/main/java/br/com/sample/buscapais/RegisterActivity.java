package br.com.sample.buscapais;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.text.TextUtils;
import android.view.View;

import br.com.sample.buscapais.util.Constants;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mName;
    private TextInputLayout mEmail;
    private TextInputLayout mPass;
    private TextInputLayout mConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
    }

    private void initViews() {
        mName = findViewById(R.id.input_name);
        mEmail = findViewById(R.id.input_email);
        mPass = findViewById(R.id.input_password);
        mConfirmPass = findViewById(R.id.input_confirm_password);
    }

    public void onClick(View view) {
        if (checkFiels()) {
            save();

            startActivity(new Intent(this, LogInActivity.class));
        }
    }

    private boolean checkFiels() {
        boolean result = true;

        mName.setError(null);
        mEmail.setError(null);
        mPass.setError(null);
        mConfirmPass.setError(null);

        if (TextUtils.isEmpty(mName.getEditText().getText().toString())) {
            mName.setError(getString(R.string.campo_obrigatorio));

            result = false;
        }

        if (TextUtils.isEmpty(mEmail.getEditText().getText().toString())) {
            mEmail.setError(getString(R.string.campo_obrigatorio));

            result = false;
        }

        if (TextUtils.isEmpty(mPass.getEditText().getText().toString())) {
            mPass.setError(getString(R.string.campo_obrigatorio));

            result = false;
        }

        if (TextUtils.isEmpty(mConfirmPass.getEditText().getText().toString())) {
            mConfirmPass.setError(getString(R.string.campo_obrigatorio));

            result = false;
        }

        if (!mPass.getEditText().getText().toString()
                .equals(mConfirmPass.getEditText().getText().toString())) {
            mPass.setError(getString(R.string.senhas_nao_conferem));
            mConfirmPass.setError(getString(R.string.senhas_nao_conferem));

            result = false;
        }

        return result;
    }

    private void save() {
        SharedPreferences.Editor editor = getSharedPreferences(Constants.PREF, MODE_PRIVATE).edit();
        editor.putString(Constants.NAME, mName.getEditText().getText().toString());
        editor.putString(Constants.EMAIL, mEmail.getEditText().getText().toString());
        editor.putString(Constants.PASS, mPass.getEditText().getText().toString());
        editor.apply();
    }
}
