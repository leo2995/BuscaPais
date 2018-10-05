package br.com.sample.buscapais;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initTimer();
    }

    private void initTimer() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, PreLogInActivity.class));
            finish();
        }, 1000);
    }
}
