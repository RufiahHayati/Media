package com.example.rplrus26.media;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.TabItem;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuizHarianDoa extends AppCompatActivity {

    Button SurahHarian, jawab1, jawab2, jawab3, jawab4;
    TextView score, question;

    private Pertanyaan mPertanyaan = new Pertanyaan();

    private String mJawab;
    private int mScore = 0;
    private int mQuestionsLenght = mPertanyaan.mPertanyaan.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_harian_doa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

        r = new Random();

        score = findViewById(R.id.textscore);
        SurahHarian = findViewById(R.id.btnSurahHarian);
        question = findViewById(R.id.textquestion);
        jawab1 = findViewById(R.id.jawab1);
        jawab2 = findViewById(R.id.jawab2);
        jawab3 = findViewById(R.id.jawab3);
        jawab4 = findViewById(R.id.jawab4);

        SurahHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surah = new Intent(QuizHarianDoa.this,quiz.class);
                startActivity(surah);
            }
        });

        score.setText("Score : " + mScore);

        updateQuestion(r.nextInt(mQuestionsLenght));

        jawab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (jawab1.getText() == mJawab){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                }else {
                    gameOver();
                }
            }
        });

        jawab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (jawab2.getText() == mJawab){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                }else {
                    gameOver();
                }
            }
        });

        jawab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (jawab3.getText() == mJawab){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                }else {
                    gameOver();
                }
            }
        });

        jawab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (jawab4.getText() == mJawab){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                }else {
                    gameOver();
                }
            }
        });

    }

    private void gameOver() {
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        String username = preferences.getString("username","");
        Log.d(""," username "+ username);
        AlertDialog.Builder alertDialogBuilder =
                new AlertDialog.Builder(this, R.style.CustomDialogTheme);
        alertDialogBuilder.setTitle(" Score ")
                .setMessage( username + " : " + mScore + " point.")
                .setIcon(R.drawable.alquran)
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), quiz.class));
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(QuizHarianDoa.this,materi.class);
                                startActivity(intent);
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void updateQuestion(int num) {

        question.setText(mPertanyaan.getPertanya(num));
        jawab1.setText(mPertanyaan.getPilih1(num));
        jawab2.setText(mPertanyaan.getPilih2(num));
        jawab3.setText(mPertanyaan.getPilih3(num));
        jawab4.setText(mPertanyaan.getPilih4(num));

        mJawab = mPertanyaan.getJawabPilih(num);
    }

    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this, materi.class));
        finish();
        return true;

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.SurahPndk:
                Intent i = new Intent(this,surahPendek.class);
                this.startActivity(i);
                return true;

            case R.id.DoaHrn:
                Intent a = new Intent(this,doa_harian.class);
                this.startActivity(a);
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
