package com.example.rplrus26.media;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class doa_harian extends AppCompatActivity {

    private LinearLayoutManager Layout1;

    SearchView Search;
    RecyclerView rView;
    RecyclerViewAdapterHarian adapterHarian;
    List<ItemObjectHarian> allItemsHarian;
    List<ItemObjectHarian> searchedItem;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_harian);

        GlobalAlquranDataList.InitialzingData();
        List<ItemObjectHarian> rowListItem = GlobalAlquranDataList.globalSurahHarianData;
        searchedItem = new ArrayList<ItemObjectHarian>();

        rView = (RecyclerView) findViewById(R.id.recycler_view1);
        rView.setHasFixedSize(true);

        Layout1 = new LinearLayoutManager(doa_harian.this);
        rView.setLayoutManager(Layout1);

        adapterHarian = new RecyclerViewAdapterHarian (doa_harian.this, allItemsHarian);
        rView.setAdapter(adapterHarian);

        RecyclerViewAdapterHarian rcAdapter = new RecyclerViewAdapterHarian(doa_harian.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    public List<ItemObjectHarian> getAllItemList() {
        allItemsHarian = new ArrayList<ItemObjectHarian>();
        allItemsHarian.add(new ItemObjectHarian("Do'a Sebelum Makan", R.drawable.alquran, R.raw.doasebelummakan, R.raw.doasebelummakann));
        allItemsHarian.add(new ItemObjectHarian("Do'a Sesudah Makan", R.drawable.alquran, R.raw.doasesudahmakan, R.raw.doasesudahmakann));
        allItemsHarian.add(new ItemObjectHarian("Do'a Sebelum Tidur", R.drawable.alquran, R.raw.doasebelumtidur, R.raw.doasebelumtidurr));
        allItemsHarian.add(new ItemObjectHarian("Do'a Bangun Tidur", R.drawable.alquran, R.raw.doabanguntidur, R.raw.doabanguntidurr));
        allItemsHarian.add(new ItemObjectHarian("Do'a Sebelum Belajar", R.drawable.alquran, R.raw.doasebelumbelajar, R.raw.doasebelumbelajarr));
        allItemsHarian.add(new ItemObjectHarian("Do'a Berbuka Puasa", R.drawable.alquran, R.raw.doaberbukapuasa, R.raw.doaberbukapuasaa));
        allItemsHarian.add(new ItemObjectHarian("Do'a Masuk Wc", R.drawable.alquran, R.raw.doamasukwc, R.raw.doamasukwcc));
        allItemsHarian.add(new ItemObjectHarian("Do'a Keluar Wc", R.drawable.alquran, R.raw.doakeluarwc, R.raw.doakeluarwcc));
        allItemsHarian.add(new ItemObjectHarian("Do'a Ketika Hujan", R.drawable.alquran, R.raw.doaketikahujan, R.raw.doaketikahujann));
        allItemsHarian.add(new ItemObjectHarian("Do'a Ditimpa Musibah", R.drawable.alquran, R.raw.doaditimpamusibah, R.raw.doaditimpamusibahh));
        allItemsHarian.add(new ItemObjectHarian("Do'a Masuk Rumah", R.drawable.alquran, R.raw.doamasukrumah, R.raw.doamasukrumahh));
        allItemsHarian.add(new ItemObjectHarian("Do'a Keluar Rumah", R.drawable.alquran, R.raw.doakeluarrumah, R.raw.doakeluarrumahh));
        allItemsHarian.add(new ItemObjectHarian("Do'a Masuk Masjid", R.drawable.alquran, R.raw.doamasukmasjid, R.raw.doamasukmasjidd));
        allItemsHarian.add(new ItemObjectHarian("Do'a Keluar Masjid", R.drawable.alquran, R.raw.doakeluarmasjid, R.raw.doakeluarmasjidd));
        allItemsHarian.add(new ItemObjectHarian("Do'a Bercermin", R.drawable.alquran, R.raw.doabercermin, R.raw.doabercerminn));
        allItemsHarian.add(new ItemObjectHarian("Do'a Berpakaian", R.drawable.alquran, R.raw.doaberpakaian, R.raw.doaberpakaiann));
        allItemsHarian.add(new ItemObjectHarian("Do'a Melepas Pakaian", R.drawable.alquran, R.raw.doamelepaspakaian, R.raw.doamembukapakaiann));
        allItemsHarian.add(new ItemObjectHarian("Do'a Bersin", R.drawable.alquran, R.raw.doabersin, R.raw.doabersinn));
        allItemsHarian.add(new ItemObjectHarian("Do'a Istinja'", R.drawable.alquran, R.raw.doaistinja, R.raw.doasebelumtidurr));
        allItemsHarian.add(new ItemObjectHarian("Do'a Naik Kendaraan", R.drawable.alquran, R.raw.doanaikkendaraan, R.raw.doanaikkendaraann));
        allItemsHarian.add(new ItemObjectHarian("Do'a Kebaikan Kedua OrangTua", R.drawable.alquran, R.raw.doakebaikankeduaorangtua, R.raw.doakeduaorangtuaa));
        allItemsHarian.add(new ItemObjectHarian("Do'a Kebaikan Dunia Dan Akhirat", R.drawable.alquran, R.raw.doakebaikanduniaakhirat, R.raw.doakebaikanduniaakheratt));
        return allItemsHarian;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem myActionMenuItem = menu.findItem(R.id.Cari);

        Search = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(Search);
        Search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                Toast.makeText(getApplicationContext(), " " + query, Toast.LENGTH_SHORT).show();
                searchedItem.clear();

                    //proses
                    for(ItemObjectHarian d : allItemsHarian){
                        if(d.getName() != null && d.getName().contains(query)){
                            Log.d("Test", "onQueryTextSubmit: "+ d.getName());

                            if(!searchedItem.contains(d))
                                searchedItem.add(d);
                        }
                    }

//                 if (!Search.isIconified()) {
//                    Search.setIconified(true);
//                }

                myActionMenuItem.collapseActionView();

                for (ItemObjectHarian sItem: searchedItem){

                    Log.d("Test", "Searched Data : "+ sItem.getName());
                }

                RecyclerViewAdapterHarian searchedItemAdapterHarian = new RecyclerViewAdapterHarian(getApplicationContext(), searchedItem);
                rView.setAdapter(searchedItemAdapterHarian);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                newText = newText.toLowerCase();
                ArrayList<ItemObjectHarian> newList = new ArrayList<>();
                return true;
            }
        });
        return true;
    }

    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view ).setTextColor(Color.WHITE);
                return;
            }else if (view instanceof ViewGroup) {
               ViewGroup viewGroup=(ViewGroup)view;
               for (int i=0; i < viewGroup.getChildCount(); i++) {
                 changeSearchViewTextColor(viewGroup.getChildAt(i));
               }
            }
        }
    }

    private List<ItemObjectHarian> filter (List<ItemObjectHarian> pl, String query) {
      query=query.toLowerCase();
      final List<ItemObjectHarian> filteredModeList = new ArrayList<>();
      for (ItemObjectHarian model:pl) {
         final String text = model.getName().toLowerCase();
         if (text.startsWith(query)) {
            filteredModeList.add(model);
         }
      }
      return filteredModeList;
    }

    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this, doa_harian.class));
        finish();
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.Cari) {
//        }else if(id == R.id.actBookmark){
//            Intent intent=new Intent(doa_harian.this,Bookmaks.class);
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
