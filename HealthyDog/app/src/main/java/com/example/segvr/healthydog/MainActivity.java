package com.example.segvr.healthydog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button hunde_button = (Button) findViewById(R.id.hunde_button);

        // Buttonevent zum Menü
        assert hunde_button != null;
        hunde_button.setOnClickListener (new View.OnClickListener(){
            @Override

            public void onClick(View v){
                goToHundeMenue();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void goToHundeMenue(){
        Intent intent = new Intent(this, HundeMenue.class);
        startActivity(intent);
    }
}
