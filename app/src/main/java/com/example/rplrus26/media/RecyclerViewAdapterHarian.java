package com.example.rplrus26.media;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;


public class RecyclerViewAdapterHarian extends RecyclerView.Adapter<RecyclerViewHolderHarian> {

    private List<ItemObjectHarian> itemListHarian;
    private Context context1;
    private Filter Filter;

    public RecyclerViewAdapterHarian(Context context1, List<ItemObjectHarian> itemList1) {
        this.itemListHarian = itemList1;
        this.context1 = context1;
    }

    @Override
    public RecyclerViewHolderHarian onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list1, null);
        RecyclerViewHolderHarian rcv = new RecyclerViewHolderHarian(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderHarian holder, final int position) {
        holder.personName.setText(itemListHarian.get(position).getName());
        holder.personLogo.setImageResource(itemListHarian.get(position).getLogoid());

        holder.klik1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent curIntent = new Intent(context1, DetailAlquran.class);
                curIntent.putExtra("Type", 1);
                curIntent.putExtra("ID", itemListHarian.get(position).getName());
                context1.startActivity(curIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemListHarian.size();
    }
    public void setFilter(ArrayList<ItemObjectHarian> newList){
        itemListHarian = new ArrayList<>();
        itemListHarian.addAll(newList);
        notifyDataSetChanged();
    }
}
