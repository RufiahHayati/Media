package com.example.rplrus26.media;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabItem;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class quiz extends AppCompatActivity {

    TextView score, question;
    Button answer1, answer2, answer3, answer4, Doa;

    private Questions mQuestions = new Questions();
    log_in user;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLenght = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        r = new Random();

        user = new log_in();

        score = findViewById(R.id.score);
        Doa = findViewById(R.id.btnDoa);
        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        Doa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent doa = new Intent(quiz.this,QuizHarianDoa.class);
                startActivity(doa);
            }
        });

        score.setText("Score : " + mScore);

        updateQuestion(r.nextInt(mQuestionsLenght));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                }else {
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));
                }else {
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));
                }else {
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score : " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));
                }else {

                    gameOver();
                }
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        moveTaskToBack(true);
    }

    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.CustomDialogTheme);
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        String username = preferences.getString("username","");
        Log.d(""," username "+ username);
        alertDialogBuilder.setTitle(" Score ")
                .setMessage( username + " : "+ mScore + " point. ")
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
                                Intent a = new Intent(quiz.this,materi.class);
                                startActivity(a);
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this, materi.class));
        finish();
        return true;

    }

    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option,menu);
//        if(menu instanceof MenuBuilder){
//            MenuBuilder menuBuilder = (MenuBuilder) menu;
//            menuBuilder.setOptionalIconsVisible(true);
//        }
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
