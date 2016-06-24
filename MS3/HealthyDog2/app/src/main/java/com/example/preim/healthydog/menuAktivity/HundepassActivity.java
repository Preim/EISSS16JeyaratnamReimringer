package com.example.preim.healthydog.menuAktivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.preim.healthydog.*;
import com.example.preim.healthydog.Dogs.ArztterimActivity;
import com.example.preim.healthydog.Dogs.DogsActivity;
import com.example.preim.healthydog.Dogs.ImpfungenActivity;

public class HundepassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hundepass);

        Button bAtermin = (Button) findViewById(R.id.bATermin);
        final Button bImpfung = (Button) findViewById(R.id.bImpfung);

        assert bAtermin != null;
        bAtermin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aTerminIntent = new Intent (HundepassActivity.this, ArztterimActivity.class);
                HundepassActivity.this.startActivity(aTerminIntent);
            }
        });

        assert bImpfung != null;
        bImpfung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent impfungIntent = new Intent(HundepassActivity.this, ImpfungenActivity.class);
                HundepassActivity.this.startActivity(impfungIntent);
            }
        });
    }


}
