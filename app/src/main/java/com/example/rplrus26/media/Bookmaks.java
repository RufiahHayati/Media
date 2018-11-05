package com.example.rplrus26.media;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rplrus26.media.database.DatabaseHelper;
import com.example.rplrus26.media.database.model.Note;

import java.util.ArrayList;
import java.util.List;

public class Bookmaks extends AppCompatActivity {

    private LinearLayoutManager Layout;
    private List<Note> notesList = new ArrayList<>();
    private RecyclerView RView;
    private NotesAdapter mAdapter;
    private DatabaseHelper db;
    TextView NotesView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmaks);

        Layout = new LinearLayoutManager(Bookmaks.this);
        RView = findViewById(R.id.RecyclerViewBookmark);
        RView.setLayoutManager(Layout);

        NotesView = findViewById(R.id.notes_view);

        db = new DatabaseHelper(this);

        notesList.addAll(db.getAllNotes());


        mAdapter = new NotesAdapter(Bookmaks.this,notesList);
        RView.setAdapter(mAdapter);

        System.out.println("Nomor Satu : "+notesList.get(0).getName());

        getSupportActionBar().setTitle("BOOKMARKS");
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RView = findViewById(R.id.RecyclerViewBookmark);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RView.addOnItemTouchListener(new RecyclerTouchListener(this, RView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
                showActionsDialog(position);
            }
        }));

    }


    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this, materi.class));
        finish();
        return true;

    }

    private void createNote(String note, String name, String resweb, int type) {
        // inserting note in db and getting
        // newly inserted note id
        long id = db.insertNote(note,name,resweb,type);
        System.out.println("sukses insert");

        Note n = db.getNote(id);

        if (n != null) {
            notesList.add(0, n);

            // refreshing the list
            mAdapter.notifyDataSetChanged();

            toggleEmptyNotes();
        }
    }

    private void toggleEmptyNotes() {
        if (db.getNotesCount() > 0) {
            NotesView.setVisibility(View.GONE);
        } else {
            NotesView.setVisibility(View.VISIBLE);
        }
    }

    private void deleteNote(int position) {
        // deleting the note from db
        db.deleteNote(notesList.get(position));

        // removing the note from the list
        notesList.remove(position);
        mAdapter.notifyItemRemoved(position);
        toggleEmptyNotes();
    }

    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Delete"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialogTheme);
        builder.setTitle("Delete");
        builder.setMessage(" Are you sure want to delete data ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                deleteNote(position);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}