package com.example.preim.healthydog.Dogs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.preim.healthydog.MenuActivity;
import com.example.preim.healthydog.R;

public class DogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);
        Button bDog1 = (Button) findViewById(R.id.bDog1);

        assert bDog1 != null;
        bDog1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToMenue();
            }
        });
    }

    private void goToMenue(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
