package com.gulecugurcan.covidincontries.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.gulecugurcan.covidincontries.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main_activity =new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(main_activity);
                finish();
              }
        },SPLASH_TIME_OUT);
    }
}