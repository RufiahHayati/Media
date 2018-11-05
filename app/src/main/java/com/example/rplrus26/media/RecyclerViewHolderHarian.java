package com.example.rplrus26.media;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolderHarian extends RecyclerView.ViewHolder {

    public TextView personName;
    public ImageView personLogo;
    public Button klik1;

    public RecyclerViewHolderHarian(View itemView) {
        super(itemView);

        personName = (TextView)itemView.findViewById(R.id.harian_doaText);
        personLogo = (ImageView)itemView.findViewById(R.id.harian_circleImage);
        klik1 = (Button)itemView.findViewById(R.id.harian_button);

    }
}
