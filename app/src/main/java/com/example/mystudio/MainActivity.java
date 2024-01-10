package com.example.mystudio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.AlarmClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflated")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cdMenu5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAlarm();
            }
        });

        findViewById(R.id.cdMenu1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helloworld = new Intent(MainActivity.this, HelloActivity.class);
                startActivity(helloworld);
            }
        });

        findViewById(R.id.cdMenu2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toast = new Intent(MainActivity.this, CountActivity.class);
                startActivity(toast);
            }
        });

        findViewById(R.id.cdMenu3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scroll = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(scroll);
            }
        });

        findViewById(R.id.cdMenu4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twoactivity = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(twoactivity);
            }
        });

        findViewById(R.id.cdMenu6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri geoLocation = Uri.parse("geo:-6.2088,106.8456");
                openMaps(geoLocation);
            }
        });

        findViewById(R.id.cdMenu7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_moviefragment = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(activity_moviefragment);
            }
        });
    }

    private void setAlarm() {
        Intent alarmIntent = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
        // Add extra details for the alarm, e.g., alarm time, label, etc.
        // alarmIntent.putExtra(...
        startActivity(alarmIntent);
    }

    private void openMaps(Uri geoLocation) {
        Intent maps = new Intent(Intent.ACTION_VIEW);
        maps.setData(geoLocation);
        if (maps.resolveActivity(getPackageManager()) != null) {
            startActivity(maps);
        }
    }
}