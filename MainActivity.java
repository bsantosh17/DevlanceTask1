package com.devlancetask.devlancetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    Button btnFetchData, btnAnalytics, btnCrashAnalytics;

    //Analytics
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFetchData = findViewById(R.id.btnFetchData);
        btnCrashAnalytics = findViewById(R.id.btnCrasha);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        impl();
    }

    private void impl() {
        btnFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,StudentData.class));
            }
        });


//CrashAnalytics
        btnCrashAnalytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException("Test Crash"); // Force a crash

            }
        });
    }
}