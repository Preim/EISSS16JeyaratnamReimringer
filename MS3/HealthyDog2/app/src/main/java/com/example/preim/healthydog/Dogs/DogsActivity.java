package com.example.preim.healthydog.Dogs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.preim.healthydog.MenuActivity;
import com.example.preim.healthydog.R;

public class DogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);
        ImageButton ibDog1 = (ImageButton) findViewById(R.id.ibDog1);

        assert ibDog1 != null;
        ibDog1.setOnClickListener(new View.OnClickListener(){
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
