package com.example.rplrus26.media;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView personName;
    public TextView personAyat;
    public ImageView personLogo;
    public Button klik;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        personName = (TextView)itemView.findViewById(R.id.person_name);
        personAyat = (TextView)itemView.findViewById(R.id.person_ayat);
        personLogo = (ImageView)itemView.findViewById(R.id.circleView);
        klik = (Button)itemView.findViewById(R.id.btnklik);

    }
}
