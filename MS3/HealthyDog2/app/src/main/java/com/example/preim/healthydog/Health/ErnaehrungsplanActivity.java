package com.example.preim.healthydog.Health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.preim.healthydog.*;

public class ErnaehrungsplanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ernaehrungsplan);

        final Button bMontag = (Button) findViewById(R.id.bMontag);
        final Button bDienstag = (Button) findViewById(R.id.bDienstag);
        final Button bMittwoch = (Button) findViewById(R.id.bMittwoch);
        final Button bDonnerstag = (Button) findViewById(R.id.bDonnerstag);
        final Button bFreitag = (Button) findViewById(R.id.bFreitag);
        final Button bSamstag = (Button) findViewById(R.id.bSamstag);
        final Button bSonntag = (Button) findViewById(R.id.bSonntag);

        assert bMontag != null;
        assert bDienstag != null;
        assert bMittwoch != null;
        assert bDonnerstag != null;
        assert bFreitag != null;
        assert bSamstag != null;
        assert bSonntag != null;

        bMontag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tagIntent = new Intent(ErnaehrungsplanActivity.this, EPTagActivity.class);
                ErnaehrungsplanActivity.this.startActivity(tagIntent);
            }
        });

        bDienstag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tagIntent = new Intent(ErnaehrungsplanActivity.this, EPTagActivity.class);
                ErnaehrungsplanActivity.this.startActivity(tagIntent);
            }
        });

        bMittwoch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tagIntent = new Intent(ErnaehrungsplanActivity.this, EPTagActivity.class);
                ErnaehrungsplanActivity.this.startActivity(tagIntent);
            }
        });

        bDonnerstag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tagIntent = new Intent(ErnaehrungsplanActivity.this, EPTagActivity.class);
                ErnaehrungsplanActivity.this.startActivity(tagIntent);
            }
        });

        bFreitag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tagIntent = new Intent(ErnaehrungsplanActivity.this, EPTagActivity.class);
                ErnaehrungsplanActivity.this.startActivity(tagIntent);
            }
        });

        bSamstag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tagIntent = new Intent(ErnaehrungsplanActivity.this, EPTagActivity.class);
                ErnaehrungsplanActivity.this.startActivity(tagIntent);
            }
        });

        bSonntag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tagIntent = new Intent(ErnaehrungsplanActivity.this, EPTagActivity.class);
                ErnaehrungsplanActivity.this.startActivity(tagIntent);
            }
        });
    }

}
