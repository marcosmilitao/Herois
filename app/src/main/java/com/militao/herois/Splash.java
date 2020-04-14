package com.militao.herois;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 3000);
    }

    private void mostrarMainActivity() {
        Intent intent = new Intent(
                Splash.this,MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}
