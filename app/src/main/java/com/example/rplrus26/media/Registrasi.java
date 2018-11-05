package com.example.rplrus26.media;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Registrasi extends AppCompatActivity {

     EditText eduser, edpassword, ednama, edalamat;
     Button regista;
     ProgressBar load;
     mbi user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        eduser = (EditText) findViewById(R.id.edituser);
        edpassword = (EditText) findViewById(R.id.editpass);

        user = new mbi();

        ednama = (EditText) findViewById(R.id.editnama);
        edalamat = (EditText) findViewById(R.id.editalamat);
        regista = (Button)findViewById(R.id.btnRegis);
        load = (ProgressBar) findViewById(R.id.progressBarmutar);

        regista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setUsername(eduser.getText().toString());
                user.setPassword(edpassword.getText().toString());
                user.setNama(ednama.getText().toString());
                user.setAlamat(edalamat.getText().toString());

                new Registrasi.LoginProcess().execute();
                if (user.getUsername().equals(" ") || user.getPassword().equals(" ")){
                    Toast.makeText(getApplicationContext(),"Notway Empty", Toast.LENGTH_SHORT).show();
                }else {
                    new LoginProcess().execute();
                }
            }

        });

    }

    public void PunyaAkun(View view){
        Intent daftar = new Intent(Registrasi.this, MainActivity.class);
        startActivity(daftar);
    }
    @SuppressLint("StaticFieldLeak")
    public class LoginProcess extends AsyncTask<Void, Void, JSONObject> {


        @Override
        protected void onPreExecute() {
            //kasih loading
            load.setVisibility(View.INVISIBLE);
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            JSONObject jsonObject;
            try {
                String tmpNama = user.getNama().replaceAll(" ","%20");
                String tmpAlamat = user.getAlamat().replaceAll(" ","%20");
                String url = "https://resarese8.000webhostapp.com/marbel/regis.php?username=" +user.getUsername() +"&nama=" +tmpNama +"&password=" +user.getPassword() +"&alamat=" +tmpAlamat +"";
                System.out.println("urlnya : " +url);
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                InputStream inputStream = httpEntity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        inputStream, "iso-8859-1"
                ), 8);
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                inputStream.close();
                String json = stringBuilder.toString();
                jsonObject = new JSONObject(json);
            } catch (Exception e) {
                jsonObject = null;
            }
            return jsonObject;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            System.out.println("hasil"+jsonObject.toString());
            Log.d("hasil json ", "onPostExecute: " + jsonObject.toString());
            load.setVisibility(View.VISIBLE);
            if (jsonObject != null) {
                try {
                    JSONObject Result = jsonObject.getJSONObject("Result");
                    String sukses = Result.getString("Sukses");
                    Log.d("hasil sukses ", "onPostExecute: " + sukses);

                    if (sukses.equals("true")) {
                        Toast.makeText(getApplicationContext(), "Register Sukses", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registrasi.this,MainActivity.class);
                        startActivity(intent);
                        //to main menu
                    } else {
                        Toast.makeText(getApplicationContext(), "Register gagal", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception ignored) {
                }
            } else {
            }
        }
    }
}
