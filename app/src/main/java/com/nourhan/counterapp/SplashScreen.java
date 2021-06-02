package com.nourhan.counterapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }, 3000);
    }
}
