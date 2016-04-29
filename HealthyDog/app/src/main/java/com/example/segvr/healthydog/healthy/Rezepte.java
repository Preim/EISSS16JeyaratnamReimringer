package com.example.segvr.healthydog.healthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.segvr.healthydog.*;

public class Rezepte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte);
        Button katButton = (Button) findViewById(R.id.kat_button);


        assert katButton != null;
        katButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToKat();
            }
        });
    }

    public void goToKat(){
        Intent intent = new Intent(this, Kategorien.class);
        startActivity(intent);
    }
}
