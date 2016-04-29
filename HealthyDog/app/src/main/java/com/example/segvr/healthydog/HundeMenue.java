package com.example.segvr.healthydog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.segvr.healthydog.aktivitaeten.Aktivitaeten;
import com.example.segvr.healthydog.fitness.Fitness;
import com.example.segvr.healthydog.healthy.*;
import com.example.segvr.healthydog.hundepass.*;
import com.example.segvr.healthydog.routen.Routen;

public class HundeMenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunde_menue);
        Button hButton = (Button) findViewById(R.id.health_button);
        Button hPassButton = (Button) findViewById(R.id.hundepass_button);
        Button fButton = (Button) findViewById(R.id.fitness_button);
        Button aButton = (Button) findViewById(R.id.aktivitaeten_button);
        Button rButton = (Button) findViewById(R.id.routen_button);

        // Buttonevent zum Health Menü
        assert hButton != null;
        hButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToHealthyMenue();
            }
        });

        // Buttonevent zum Hunde Pass
        assert hPassButton != null;
        hPassButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToHundePass();
            }
        });

        // Buttonevent zu Fitness
        assert fButton != null;
        fButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToFitness();
            }
        });

        // Buttonevent zu Aktivitäten
        assert aButton != null;
        aButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToAktivitaeten();
            }
        });

        // Buttonevent zu Routen
        assert rButton != null;
        rButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToRouten();
            }
        });
    }
    // Healthy Menü
    public void goToHealthyMenue(){
        Intent intent = new Intent(this, HealthyMenue.class);
        startActivity(intent);
    }
    // Hunde Pass
    public void goToHundePass(){
        Intent passIntent = new Intent(this, HundePass.class);
        startActivity(passIntent);
    }
    // Fitness
    public void goToFitness(){
        Intent fitIntent = new Intent(this, Fitness.class);
        startActivity(fitIntent);
    }
    // Aktivitäten
    public void goToAktivitaeten(){
        Intent aktIntent = new Intent(this, Aktivitaeten.class);
        startActivity(aktIntent);
    }
    // Routen
    public void goToRouten(){
        Intent rIntent = new Intent(this, Routen.class);
        startActivity(rIntent);
    }
}
