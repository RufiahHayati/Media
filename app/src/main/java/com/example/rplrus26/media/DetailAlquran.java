package com.example.rplrus26.media;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rplrus26.media.database.DatabaseHelper;
import com.example.rplrus26.media.database.model.Note;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.example.rplrus26.media.database.model.Note.COLUMN_NAME;
import static com.example.rplrus26.media.database.model.Note.COLUMN_NOTE;
import static com.example.rplrus26.media.database.model.Note.COLUMN_RESWEB;


public class DetailAlquran extends AppCompatActivity {

    private List<Note> notesList = new ArrayList<>();
    private Note notes;
    private DatabaseHelper db;
    int type;
   // private NotesAdapter mAdapter;

    private boolean isEdit=false;
    private Menu menu;

    public enum TypeDetail {Alquran, Harian}


    //Media Player System Rerences.
    MediaPlayer mediaPlayer;
    int audioResID;
    String surat;
    String note;
    String ayat;
    int resweb;
    String IDDataAlquran;
    String IDDataDoaHarian;

    TextView suratName;
    ImageButton playSound;

    WebView content;
    private int contentIndex;

    ImageButton prevButton;
    ImageButton nextButton;


    ItemObject currentItemObjectInspect;
    ItemObjectHarian currentItemObjectHarianInspect;
    Note currentNote;

    SearchView SearchPendek;
    RecyclerView rView;
    List<ItemObject> searchedItem;

    private void createNote(String note,String name,String resweb, int type) {
        // inserting note in db and getting
        // newly inserted note id
        long id = db.insertNote(note,name,resweb,type);

        System.out.println("sukses insert");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailalquran);
       // mAdapter = new NotesAdapter(this, notesList);

        db = new DatabaseHelper(this);
        int typeData = getIntent().getIntExtra("Type", 0);
        type = typeData;

        switch (typeData){

            // Alquran.
            case 0:
                InitReferences(TypeDetail.Alquran);
                DataReciever(TypeDetail.Alquran);
                Log.d("TypeData Called", "Alquran");
                break;

            // Harian.
            case 1:
                InitReferences(TypeDetail.Harian);
                DataReciever(TypeDetail.Harian);
                Log.d("TypeData Called", "Harian");
                break;
        }

    }

    protected void DataReciever(TypeDetail detail){

        Intent detailIntent = getIntent();

        GlobalAlquranDataList.InitialzingData();

        // Alquran Data Type.
        if(detail == TypeDetail.Alquran) {

            IDDataAlquran = detailIntent.getStringExtra("ID");
            content.getSettings().setBuiltInZoomControls(true);
            content.getSettings().setSupportZoom(true);
            content.getSettings().setDisplayZoomControls(true);
            for (int index = 0; index < GlobalAlquranDataList.globalAlquranData.size(); index++) {

                if (GlobalAlquranDataList.globalAlquranData.get(index).getName().equals(IDDataAlquran)) {
                    currentItemObjectInspect = GlobalAlquranDataList.globalAlquranData.get(index);
                    contentIndex = index;
                    break;
                }
            }

            if (currentItemObjectInspect == null) {
                for (int x = 0; x < GlobalAlquranDataList.globalSurahHarianData.size(); x++) {
                    if (GlobalAlquranDataList.globalSurahHarianData.get(x).getName().equals(IDDataAlquran)) {
                        currentItemObjectHarianInspect = GlobalAlquranDataList.globalSurahHarianData.get(x);
                        contentIndex = x;
                        break;
                    }
                }
            }

            if (currentItemObjectInspect != null) {
//          resweb = currentItemObjectInspect.getResWeb();
                ayat = currentItemObjectInspect.getAyat();
                surat = currentItemObjectInspect.getName();
            } else
            {
                ayat = currentItemObjectHarianInspect.getName();
                surat = currentItemObjectHarianInspect.getName();
            }

            // Initialzing.
            suratName.setText(ayat);
            suratName.setText(surat);
            Log.d("TAG", "DataReciever: "+currentItemObjectInspect.getName());
            audioResID = currentItemObjectInspect.getAudioData();

            if (android.os.Build.VERSION.SDK_INT >= 23) {
                content.loadDataWithBaseURL(null, readTextFromResource(currentItemObjectInspect.getResWeb()), "text/html", "utf-8", null);
            } else {
                content.loadData(readTextFromResource(currentItemObjectInspect.getResWeb()), "text/html", "utf-8");
            }
           mediaPlayer = MediaPlayer.create(getApplicationContext(), audioResID);

         // Harian Data Type.
        }else if(detail == TypeDetail.Harian) {

            IDDataDoaHarian = detailIntent.getStringExtra("ID");
            content.getSettings().setBuiltInZoomControls(true);
            content.getSettings().setSupportZoom(true);
            content.getSettings().setDisplayZoomControls(true);
            for (int index = 0; index < GlobalAlquranDataList.globalSurahHarianData.size(); index++) {

                if (GlobalAlquranDataList.globalSurahHarianData.get(index).getName().equals(IDDataDoaHarian)) {
                    currentItemObjectHarianInspect = GlobalAlquranDataList.globalSurahHarianData.get(index);
                    contentIndex = index;
                    break;
                }
            }

            surat = currentItemObjectHarianInspect.getName();
            //Initialziing.
            suratName.setText(surat);
            audioResID = currentItemObjectHarianInspect.getAudioData();



            if (android.os.Build.VERSION.SDK_INT >= 23) {
                content.loadDataWithBaseURL(null, readTextFromResource(currentItemObjectHarianInspect.getResWeb()), "text/html", "utf-8", null);
            } else {
                content.loadData(readTextFromResource(currentItemObjectHarianInspect.getResWeb()), "text/html", "utf-8");
            }
        }

        mediaPlayer = MediaPlayer.create(getApplicationContext(), audioResID);

    }
    protected void InitReferences(TypeDetail typeDetail){

        suratName  = findViewById(R.id.detail_suratName);
        playSound  = findViewById(R.id.detail_playSound);
        content    = findViewById(R.id.detail_content);
        prevButton = findViewById(R.id.detail_prevButton);
        nextButton = findViewById(R.id.detail_nextButton);

        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        // Alquran
        if(typeDetail == TypeDetail.Alquran) {

            // Next Button functionality.
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mediaPlayer.stop();
                    mediaPlayer.reset();


                    if (contentIndex >= 0 && contentIndex != (GlobalAlquranDataList.globalAlquranData.size() - 1)) {
                        contentIndex++;
                        currentItemObjectInspect = GlobalAlquranDataList.globalAlquranData.get(contentIndex);

                        Update(TypeDetail.Alquran);

                        Log.d("IndexContent", String.valueOf(contentIndex));
                        Log.d("Audio", String.valueOf(audioResID));

                    }
                }
            });

            // Previous Button functionality.
            prevButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    if (contentIndex <= GlobalAlquranDataList.globalAlquranData.size() && contentIndex != 0) {
                        contentIndex--;
                        currentItemObjectInspect = GlobalAlquranDataList.globalAlquranData.get(contentIndex);

                        Update(TypeDetail.Alquran);

                        Log.d("IndexContent", String.valueOf(contentIndex));
                        Log.d("Audio", String.valueOf(audioResID));
                    }
                }
            });

            // Harian
        }else if(typeDetail == TypeDetail.Harian){

            //Next Button functionality.
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    if (contentIndex >= 0 && contentIndex != (GlobalAlquranDataList.globalSurahHarianData.size() - 1)) {
                        contentIndex++;
                        currentItemObjectHarianInspect = GlobalAlquranDataList.globalSurahHarianData.get(contentIndex);

                        Update(TypeDetail.Harian);

                        Log.d("IndexContent", String.valueOf(contentIndex));
                        Log.d("Audio", String.valueOf(audioResID));
                    }
                }
            });

            //Previous Button functionality.
            prevButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    if (contentIndex <= GlobalAlquranDataList.globalSurahHarianData.size() && contentIndex != 0) {
                        contentIndex--;
                        currentItemObjectHarianInspect = GlobalAlquranDataList.globalSurahHarianData.get(contentIndex);

                        Update(TypeDetail.Harian);

                        Log.d("IndexContent", String.valueOf(contentIndex));
                        Log.d("Audio", String.valueOf(audioResID));
                    }
                }
            });

        }

    }
    private String readTextFromResource(int dataRes) {

        InputStream raw = getResources().openRawResource(dataRes);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int i;
        try
        {
            i = raw.read();
            while (i != -1)
            {
                stream.write(i);
                i = raw.read();
            }
            raw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return stream.toString();
    }
    private void Update(TypeDetail typeDetail){

        if(typeDetail == TypeDetail.Alquran) {

            suratName.setText(currentItemObjectInspect.getName());
            audioResID = currentItemObjectInspect.getAudioData();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), audioResID);

            if (android.os.Build.VERSION.SDK_INT >= 23) {
                content.loadDataWithBaseURL(null, readTextFromResource(currentItemObjectInspect.getResWeb()), "text/html", "utf-8", null);
            } else {
                content.loadData(readTextFromResource(currentItemObjectInspect.getResWeb()), "text/html", "utf-8");
            }

        } else if(typeDetail == TypeDetail.Harian){

            suratName.setText(currentItemObjectHarianInspect.getName());
            audioResID = currentItemObjectHarianInspect.getAudioData();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), audioResID);

            if (android.os.Build.VERSION.SDK_INT >= 23) {
                content.loadDataWithBaseURL(null, readTextFromResource(currentItemObjectHarianInspect.getResWeb()), "text/html", "utf-8", null);
            } else {
                content.loadData(readTextFromResource(currentItemObjectHarianInspect.getResWeb()), "text/html", "utf-8");
            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater getMenuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_marks, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionBookmark:
                createNote(surat,ayat,"", type);
                Log.d("Hello", "onOptionsItemSelected: " + surat + type);
                Toast.makeText(getApplicationContext(), " Bookmark is Selected ", Toast.LENGTH_SHORT).show();
                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.bookmark0));
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem settingsItem = menu.findItem(R.id.actionBookmark);
        menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.bookmark0));
        // set your desired icon here based on a flag if you like
        settingsItem.setIcon(getResources().getDrawable(R.drawable.bookmark1));
        return super.onPrepareOptionsMenu(menu);
    }

}