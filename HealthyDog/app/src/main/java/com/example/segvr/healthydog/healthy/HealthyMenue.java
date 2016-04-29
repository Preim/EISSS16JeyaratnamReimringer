package com.example.segvr.healthydog.healthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.segvr.healthydog.R;

public class HealthyMenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healty_menue);

        Button foodButton = (Button) findViewById(R.id.foodplaner_button);
        Button rezButton = (Button) findViewById(R.id.rezepte_button);

        assert foodButton != null;
        foodButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToFoodPlaner();
            }
        });

        assert rezButton != null;
        rezButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToRezepte();
            }
        });
    }
    public void goToFoodPlaner(){
        Intent intent = new Intent(this, FoodPlaner.class);
        startActivity(intent);
    }

    public void goToRezepte(){
        Intent rezIntent = new Intent(this, Rezepte.class);
        startActivity(rezIntent);
    }
}
