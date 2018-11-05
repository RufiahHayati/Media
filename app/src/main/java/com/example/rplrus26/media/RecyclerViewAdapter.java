package com.example.rplrus26.media;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<ItemObject> itemList;

    private Context context;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        RecyclerViewHolder rcv = new RecyclerViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

        holder.personName.setText(itemList.get(position).getName());
        holder.personAyat.setText(itemList.get(position).getAyat());
        holder.personLogo.setImageResource(itemList.get(position).getLogoid());

        holder.klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent curIntent = new Intent(context, DetailAlquran.class);
                curIntent.putExtra("Type", 0);
                curIntent.putExtra("ID", itemList.get(position).getName());
                context.startActivity(curIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
