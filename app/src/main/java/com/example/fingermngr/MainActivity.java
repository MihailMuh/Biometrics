package com.example.fingermngr;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
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

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void generateFingerMgr(View view) {
        biometrics.generateFingerMgr();
    }
}