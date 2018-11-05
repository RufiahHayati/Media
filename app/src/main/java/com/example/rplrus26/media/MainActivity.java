package com.example.rplrus26.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class    MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    EditText tusername, tpassword;
    Button btnlogin;
    TextView textregst;
    ProgressBar mutar;
    CheckBox checkBox;
    log_in user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tusername = (EditText) findViewById(R.id.edtusername);
        tpassword = (EditText) findViewById(R.id.edtpass);
        mutar = (ProgressBar) findViewById(R.id.load);
        textregst = (TextView)findViewById(R.id.textregst);
        checkBox = (CheckBox)findViewById(R.id.checkboxPass);

        user = new log_in();

        btnlogin = (Button) findViewById(R.id.btnlogin);

        SharedPreferences.Editor editor;
        pref = getSharedPreferences("testapp", MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("register", "true");
        editor.commit();
        String getStatus=pref.getString("register","nil");
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cek ke server
                user.setUsername(tusername.getText().toString());
                user.setPassword(tpassword.getText().toString());
                if (user.getUsername().equals("") || user.getPassword().equals("")){
                    Toast.makeText(getApplicationContext(),"Notway Empty", Toast.LENGTH_SHORT).show();
                }else {
                    new LoginProcess().execute();
                }
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked){
                    tpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else {
                    tpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialogTheme);
        builder.setTitle(" Apakah Anda ingin keluar ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                    navigation.this.finish();
                finish();
                moveTaskToBack(true);
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void BuatAkun(View view){
        Intent daftar = new Intent(MainActivity.this, Registrasi.class);
        startActivity(daftar);
    }

    @SuppressLint("StaticFieldLeak")
    public class LoginProcess extends AsyncTask<Void, Void, JSONObject> {


        @Override
        protected void onPreExecute() {
            //kasih loading
            mutar.setVisibility(View.VISIBLE);
            btnlogin.setVisibility(View.INVISIBLE);
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            JSONObject jsonObject;
            try {
                String url = "https://resarese8.000webhostapp.com/marbel/login.php?username=" +user.getUsername()+ "&password=" +user.getPassword()+ "";
                System.out.println("urlnya : "+url);
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
            //String url = "http://192.168.6.204/login/getData.php";
            System.out.println("hasil" +jsonObject.toString());
            Log.d("hasil json ", "onPostExecute: " + jsonObject.toString());
            mutar.setVisibility(View.VISIBLE);
            if (jsonObject != null) {
                try {
                    JSONObject Result = jsonObject.getJSONObject("Result");
                    String sukses = Result.getString("Sukses");
                    Log.d("hasil sukses ", "onPostExecute: " + sukses);

                    if (sukses.equals("true")) {
                        Toast.makeText(getApplicationContext(), "login berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,materi.class);
                        startActivity(intent);

                        SharedPreferences sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", user.getUsername());
                        editor.commit();
                        //to main menu
                    } else {
                        Toast.makeText(getApplicationContext(), "login gagal", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception ignored) {
                }
            } else {
            }
        }
    }
}
