package com.example.preim.healthydog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.preim.healthydog.Dogs.DogsActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPasswort = (EditText) findViewById(R.id.etPasswort);
        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final Button bLogin = (Button) findViewById(R.id.bLogin);

        assert bRegister != null;
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        assert bLogin != null;
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginActivity.this, DogsActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            }
        });
    }
}
