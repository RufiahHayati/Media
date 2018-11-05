package com.example.rplrus26.media;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rplrus26.media.database.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    int type;
    private Context context;
    private List<Note> notesList;
    private List<ItemObject> itemList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView note;
        public TextView name;
        public TextView ayat;
        public Button clik;

        public MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.cView);
            note = view.findViewById(R.id.not);
            name = view.findViewById(R.id.pname);
            ayat = view.findViewById(R.id.payat);
            clik = view.findViewById(R.id.btklik);
        }
    }


    public NotesAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
        this.type = type;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        MyViewHolder holder=new MyViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Note note = notesList.get(position);

        holder.note.setText(note.getNote());
        holder.name.setText(note.getName());
        holder.ayat.setText(Html.fromHtml("&#8226;"));

        holder.clik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent curIntent = new Intent(context, DetailAlquran.class);
                curIntent.putExtra("Type", note.getType());
                System.out.println("Type" + note.getType()+"");
                curIntent.putExtra("ID", note.getNote());
                context.startActivity(curIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

//    private String formatDate(String dateStr) {
//        try {
//            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = fmt.parse(dateStr);
//            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
//            return fmtOut.format(date);
//        } catch (ParseException e) {
//
//        }
//
//        return "";
//    }
}