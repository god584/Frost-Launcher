package com.frost.launcher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnMainLaunch;
    private TextView tvCurrentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frost_dashboard);

        btnMainLaunch = findViewById(R.id.btnMainLaunch);
        tvCurrentAccount = findViewById(R.id.tvCurrentAccount);

        // Account Handler Setup
        tvCurrentAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Open Account Dialog (Microsoft, Ely.by, Local)
                Toast.makeText(MainActivity.this, "Opening Account Manager...", Toast.LENGTH_SHORT).show();
            }
        });

        // Launch Button Action
        btnMainLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Initializing Frost Engine & High FPS Runtime...", Toast.LENGTH_LONG).show();
                startMinecraftEngine();
            }
        });
    }

    private void startMinecraftEngine() {
        // Core Java execution and LWJGL runtime hook goes here
    }
                  }
