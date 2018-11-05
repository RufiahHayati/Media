package com.example.rplrus26.media;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sharedpreferenc extends AppCompatActivity {

    public static final String data = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences(data, Context.MODE_PRIVATE);
        int number = sharedPreferences.getInt("isLogged", 0);
        if (number == 0) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("isLogged", 1);
            editor.commit();
            finish();
            Intent intent = new Intent(Sharedpreferenc.this, MainActivity.class);
            startActivity(intent);
        }

        else {
            Intent intent = new Intent(Sharedpreferenc.this, materi.class);
            finish();
            startActivity(intent);
        }
    }
}
