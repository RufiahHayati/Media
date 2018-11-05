package com.example.rplrus26.media;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class materi extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageButton SurahPdk, DoaHrn, Bookmk, Quis;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        setTitle("   Home");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        Bitmap b = ((BitmapDrawable)getResources().getDrawable(R.drawable.alquran)).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 80, 92, false);

        toolbar.setLogo(new BitmapDrawable(getResources(), bitmapResized));


        SurahPdk = findViewById(R.id.SurahPendek);
        DoaHrn = findViewById(R.id.DoaHarian);
        Bookmk = findViewById(R.id.Bookmarks);
        Quis = findViewById(R.id.Quiz);

        menu = (Menu) findViewById(R.id.Exit);
        SurahPdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SP = new Intent(materi.this,surahPendek.class);
                SP.putExtra("Type", 0);
                startActivity(SP);
            }
        });


        DoaHrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DH = new Intent(materi.this,doa_harian.class);
                DH.putExtra("Type", 1);
                startActivity(DH);
            }
        });


        Bookmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent B = new Intent(materi.this,Bookmaks.class);
                startActivity(B);
            }
        });

        Quis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Q = new Intent(materi.this,quiz.class);
                startActivity(Q);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.luar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.Exit: moveTaskToBack(true);
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
