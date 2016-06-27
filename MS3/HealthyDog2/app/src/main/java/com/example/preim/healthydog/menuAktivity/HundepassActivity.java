package com.example.preim.healthydog.menuAktivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.preim.healthydog.*;
import com.example.preim.healthydog.Dogs.ArztterimActivity;
import com.example.preim.healthydog.Dogs.DogsActivity;
import com.example.preim.healthydog.Dogs.ImpfungenActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HundepassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hundepass);

        Globals g = Globals.getInstance();
        final String ipAdress = g.getData();

        //Führt die GETData mit der Datenbank adresse aus
        new GetDataTask().execute("http://" + ipAdress + "/api/user/");




        // Buttons werden zugewiesen
        Button bAtermin = (Button) findViewById(R.id.bATermin);
        final Button bImpfung = (Button) findViewById(R.id.bImpfung);

        // Hier wereden Die Buttons verlinkt
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
    // Die Klasse GetData stellt die verbindung zum Server und den Daten
    class GetDataTask extends AsyncTask<String, Void, Void> {

        ProgressDialog progressDialog;

        // Vor dem Ausführen
        @Override
        protected void onPreExecute() {

            super.onPreExecute();


            progressDialog = new ProgressDialog(HundepassActivity.this);
            progressDialog.setMessage("Loading data...");
            progressDialog.show();
        }
        // Background fehler abfrage
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

        //wenns Ausgeführt ist, dann wird diese MEthode angewendet
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

        private Void getData(String urlPath) throws IOException, JSONException {
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = null;

            try {
                //Initialize and config request, then connect to server
                // Anfrage und Verbindung zum Server
                URL url = new URL(urlPath);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(10000 /* milliseconds */);
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Content-Type", "application/json");// set header
                urlConnection.connect();

                //Read data response from server
                // Liest die Daten durch
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
            JSONArray parentArray = parentObject.getJSONArray("hund");

            // Hier wird das Array durchgegangen

            for (int i= 0; i< parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(0);


                String hundename = finalObject.getString("name");
                String hunderasse = finalObject.getString("rasse");
                double gewicht = finalObject.getDouble("gewicht");
                double groesse = finalObject.getDouble("groesse");
                int alter = finalObject.getInt("alter");
                TextView tvHundename = (TextView) findViewById(R.id.tvName);
                TextView tvHunderasse = (TextView) findViewById(R.id.tvRasse);
                TextView tvGewicht = (TextView) findViewById(R.id.tvGewicht);
                TextView tvGroesse = (TextView) findViewById(R.id.tvGroesse);
                TextView tvAlter = (TextView) findViewById(R.id.tvAlter);


                // Die jeweiligen namen wird es hier zugewiesen
                tvHundename.setText("Name: " + hundename);
                tvHunderasse.setText("Rasse: " + hunderasse);
                tvGewicht.setText("Gewicht: " + gewicht);
                tvGroesse.setText("Größe: " + groesse);
                tvAlter.setText("Alter: " + alter);
            }
            return null;
        }
    }
}
