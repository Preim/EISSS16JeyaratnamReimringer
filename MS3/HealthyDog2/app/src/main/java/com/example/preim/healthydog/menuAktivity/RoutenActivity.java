package com.example.preim.healthydog.menuAktivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.preim.healthydog.*;
import com.example.preim.healthydog.Routen.MapsActivity;

public class RoutenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routen);

        final Button bMaps = (Button) findViewById(R.id.bMaps);

        assert bMaps != null;
        bMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsIntent = new Intent(RoutenActivity.this, MapsActivity.class);
                RoutenActivity.this.startActivity(mapsIntent);
            }
        });
    }
}
