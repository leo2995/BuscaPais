package br.com.sample.buscapais;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PreLogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_log_in);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.log_in:
                startActivity(new Intent(this, LogInActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deseja Realmente Sair?");

        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("NÃO", null);
        builder.create();
        builder.show();
    }
}
