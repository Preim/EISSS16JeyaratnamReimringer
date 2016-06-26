package com.example.preim.healthydog;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.example.preim.healthydog.menuAktivity.*;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton bHundepass = (ImageButton) findViewById(R.id.bHundpass);
        ImageButton bHealth = (ImageButton) findViewById(R.id.bHealth);
        ImageButton bAktivitaeten = (ImageButton) findViewById(R.id.bAktivitaeten);
        ImageButton bFitness = (ImageButton) findViewById(R.id.bFitness);
        ImageButton bWetter = (ImageButton) findViewById(R.id.bWetter);
        ImageButton bRouten = (ImageButton) findViewById(R.id.bRouten);

        //Action bar
        //getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setTitle("Menü");

        assert bHundepass != null;
        bHundepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hundepassIntent = new Intent(MenuActivity.this, HundepassActivity.class);
                MenuActivity.this.startActivity(hundepassIntent);
            }
        });

        assert bHealth != null;
        bHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent healthIntent = new Intent(MenuActivity.this, HealthActivity.class);
                MenuActivity.this.startActivity(healthIntent);
            }
        });

        assert bAktivitaeten != null;
        bAktivitaeten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aktivitaetenIntent = new Intent(MenuActivity.this, AktivitaetenActivity.class);
                MenuActivity.this.startActivity(aktivitaetenIntent);
            }
        });

        assert bFitness != null;
        bFitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fitnessIntent = new Intent(MenuActivity.this, FitnessActivity.class);
                MenuActivity.this.startActivity(fitnessIntent);
            }
        });

        assert bWetter != null;
        bWetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wetterIntent = new Intent(MenuActivity.this, WetterActivity.class);
                MenuActivity.this.startActivity(wetterIntent);
            }
        });

        assert bRouten != null;
        bRouten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent routenIntent = new Intent(MenuActivity.this, RoutenActivity.class);
                MenuActivity.this.startActivity(routenIntent);
            }
        });


    }
}
