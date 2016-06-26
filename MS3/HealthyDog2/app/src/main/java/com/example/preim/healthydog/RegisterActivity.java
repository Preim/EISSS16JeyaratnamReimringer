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

import com.example.preim.healthydog.Dogs.DogsActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etcheck = (EditText) findViewById(R.id.etPasswort);
        final EditText etcheckcheck = (EditText) findViewById(R.id.etPWwiederholen);
        assert etcheck != null;
        final String passwort = etcheck.getText().toString();
        assert etcheckcheck != null;
        final String pwWiederholen = etcheckcheck.getText().toString();


        final Button bRegister = (Button) findViewById(R.id.bRegister);
        assert bRegister != null;
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (passwort.equals(pwWiederholen)) {
                    new PostDataTask().execute("http://192.168.0.102:1000/api/user/");
                    Toast.makeText(RegisterActivity.this, "Registrierung erfolgreich", Toast.LENGTH_SHORT).show();
                    Intent regiIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    RegisterActivity.this.startActivity(regiIntent);
                }else{
                    Toast.makeText(RegisterActivity.this,"Passwort stimmt nich überein", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    class PostDataTask extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                return postData(params[0]);
            } catch (IOException ex) {
                return "Network error!";
            } catch (JSONException ex) {
                return "Data Invalid!";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }

        private String postData(String urlPath) throws IOException, JSONException {

            final EditText etUsername = (EditText) findViewById(R.id.etUsername);
            final EditText etEmail = (EditText) findViewById(R.id.etEmail);
            final EditText etPasswort = (EditText) findViewById(R.id.etPasswort);
            final EditText etPWwiederholen = (EditText) findViewById(R.id.etPWwiederholen);

            StringBuilder result = new StringBuilder();
            BufferedWriter bufferedWriter = null;
            BufferedReader bufferedReader = null;
            assert etUsername != null;
            String username = etUsername.getText().toString();
            assert etEmail != null;
            final String email = etEmail.getText().toString();
            assert etPasswort != null;
            final String passwort = etPasswort.getText().toString();
            assert etPWwiederholen != null;
            final String pwWiederholen = etPWwiederholen.getText().toString();

            try {
                //Create data to send to server
                JSONObject dataToSend = new JSONObject();
                dataToSend.put("username", username);
                dataToSend.put("passwort", passwort);
                dataToSend.put("email", email);

                //Initialize and config request, then connect to server
                URL url = new URL(urlPath);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(10000 /* milliseconds */);
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true); //enable output (body data)
                urlConnection.setRequestProperty("Content-Type", "application/json");// set header
                urlConnection.connect();

                //Write data into server
                OutputStream outputStream = urlConnection.getOutputStream();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(dataToSend.toString());
                bufferedWriter.flush();

                //Read data response from server
                InputStream inputStream = urlConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

            }


            return result.toString();
        }
    }
}
