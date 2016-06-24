package com.example.preim.healthydog.menuAktivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.preim.healthydog.*;
import com.example.preim.healthydog.Health.ErnaehrungsplanActivity;
import com.example.preim.healthydog.Health.RezepteActivity;
import com.example.preim.healthydog.Health.ScannerActivity;

public class HealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        final Button bErnaehrung = (Button) findViewById(R.id.bErnaehrung);
        final Button bScanner = (Button) findViewById(R.id.bScanner);
        final Button bRezepte = (Button) findViewById(R.id.bRezepte);

        assert bErnaehrung != null;
        assert bScanner != null;
        assert bRezepte != null;

        bErnaehrung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ernaehrungIntent = new Intent(HealthActivity.this, ErnaehrungsplanActivity.class);
                HealthActivity.this.startActivity(ernaehrungIntent);
            }
        });

        bScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scannerIntent = new Intent(HealthActivity.this, ScannerActivity.class);
                HealthActivity.this.startActivity(scannerIntent);
            }
        });

        bRezepte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rezepteIntent = new Intent(HealthActivity.this, RezepteActivity.class);
                HealthActivity.this.startActivity(rezepteIntent);
            }
        });
    }
}
