package com.example.biometrics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Biometrics biometrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        biometrics = new Biometrics(this);
    }

    public void authenticate(View view) {
        biometrics.generateFingerMgr();
    }
}