package com.evo.activitysettings;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to open WifiP2P Settings
        Button openWifiP2PSettingsButton = findViewById(R.id.openWifiP2PSettingsButton);
        openWifiP2PSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity("com.android.settings.Settings$WifiP2pSettingsActivity");
            }
        });

        // Button to open Settings
        Button openSettingsButton = findViewById(R.id.openSettingsButton);
        openSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity("com.android.settings.Settings");
            }
        });

        // Button to open Wi-Fi Preferences
        final Button wifiButton = findViewById(R.id.wifi);
        wifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity("com.android.settings.Settings$ConfigureWifiSettingsActivity");
            }
        });

        // Button to open Developer
        final Button developer = findViewById(R.id.developer);
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity("com.android.settings.Settings$DevelopmentSettingsDashboardActivity");
            }
        });


        // Button to open Cast to Monitor
        final Button castButton = findViewById(R.id.cast);
        castButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hide all buttons except Cast
                openSettingsActivity("com.android.settings.Settings$WifiDisplaySettingsActivity");
            }
        });

        final Button mmi = findViewById(R.id.mmi);
        mmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to open the specific activity
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.orionfactorymmi", "com.android.orionfactorymmi.OrionFactoryMmi"));

                // Start the activity
                startActivity(intent);
            }
        });


        // Button to Exit the application
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });
    }

    private void openSettingsActivity(String activityName) {
        // Create an intent to open the specific activity
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.android.settings", activityName));

        // Start the activity
        startActivity(intent);
    }
}
