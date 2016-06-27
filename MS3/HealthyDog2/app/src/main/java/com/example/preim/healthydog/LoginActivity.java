package com.example.preim.healthydog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.example.preim.healthydog.Dogs.DogsActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Globals g = Globals.getInstance();
        final String ipAdress = g.getData();

        // action bar
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.abs_layout);
        getSupportActionBar().setTitle("Login");





        // Buttons werden zugewiesen
        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final Button bOhneLogin = (Button) findViewById(R.id.bOhneLogin);


        assert bRegister != null;
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        assert bOhneLogin != null;
        bOhneLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(LoginActivity.this, DogsActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            }
        });
        assert bLogin != null;
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent loginIntent = new Intent(LoginActivity.this, DogsActivity.class);
                //LoginActivity.this.startActivity(loginIntent);
                new GetDataTask().execute("http://" + ipAdress  + "/api/user/");
            }
        });
    }
    // Die Klasse GetData stellt die verbindung zum Server und den Daten
    class GetDataTask extends AsyncTask<String, Void, Void> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){

            super.onPreExecute();

            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setMessage("Loading data...");
            progressDialog.show();
        }

        //Fehler abfrage
        @Override
        protected Void doInBackground(String... params) {
            try {
                return getData(params[0]);
            } catch (IOException ex) {
                //return "Network error!";
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            //set data response to textView
            //mResult.setText(result);


            //cancel progress dialog
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        // Hier ist der Konstruktor
        // Stellt die Verbindung her und gibt die Daten
        private Void getData(String urlPath) throws IOException, JSONException {
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = null;

            try {
                //Initialize and config request, then connect to server
                //Anfrage und verbindung zum Server
                URL url = new URL(urlPath);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(10000 /* milliseconds */);
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Content-Type", "application/json");// set header
                urlConnection.connect();

                //Read data response from server
                InputStream inputStream = urlConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }

            String finalJson = result.toString();

            JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArray = parentObject.getJSONArray("user");

            for (int i= 0; i< parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(0);
                String username = finalObject.getString("username");
                String passwort = finalObject.getString("passwort");
                EditText etUsername = (EditText) findViewById(R.id.etUsername);
                EditText etPasswort = (EditText) findViewById(R.id.etPasswort);
                if (etUsername != null && etPasswort != null) {
                    if (username.equals(etUsername.getText().toString()) && passwort.equals(etPasswort.getText().toString())) {
                        Intent loginIntent = new Intent(LoginActivity.this, DogsActivity.class);
                        LoginActivity.this.startActivity(loginIntent);
                        Toast.makeText(LoginActivity.this, "Login erfolgreich", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login fehlgeschlagen", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            return null;
        }
    }
}
