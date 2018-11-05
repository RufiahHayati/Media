package com.example.rplrus26.media;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class surahPendek extends AppCompatActivity {

    private LinearLayoutManager Layout;
    SearchView SearchPendek;
    RecyclerView rView;
    RecyclerViewAdapter adapter;
    List<ItemObject> allItems;
    List<ItemObject> searchedItem;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_pendek);

        List<ItemObject> rowListItem = getAllItemList();

        GlobalAlquranDataList.InitialzingData();
        if(GlobalAlquranDataList.globalAlquranData != null)
            GlobalAlquranDataList.globalAlquranData = rowListItem;

        searchedItem = new ArrayList<ItemObject>();

        Layout = new LinearLayoutManager(surahPendek.this);

        //SearchPendek = (SearchView)findViewById(R.id.Cari);
        rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(Layout);

        adapter = new RecyclerViewAdapter(surahPendek.this, allItems);
        rView.setAdapter(adapter);

        RecyclerViewAdapter searchedItemAdapter = new RecyclerViewAdapter(getApplicationContext(), searchedItem);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(surahPendek.this, rowListItem);
        rView.setAdapter(rcAdapter);


    }

    private List<ItemObject> getAllItemList(){

        allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Surah Al-Fatihah", "٧-١", R.drawable.alquran, R.raw.alfatihah, R.raw.alfatihahh));
        allItems.add(new ItemObject("Surah Ad-Dhuha", "١١-١", R.drawable.alquran, R.raw.addhuha, R.raw.addhuhaa));
        allItems.add(new ItemObject("Surah Al-Insyiroh", "٨-١", R.drawable.alquran, R.raw.alinsyiroh, R.raw.alinsyirohh));
        allItems.add(new ItemObject("Surah At-Tiin", "٨-١", R.drawable.alquran, R.raw.attiin, R.raw.attinn ));
        allItems.add(new ItemObject("Surah Al-'Alaq", "١٩-١", R.drawable.alquran, R.raw.alalaq, R.raw.alalaqq));
        allItems.add(new ItemObject("Surah Al-Qadr", "٥-١", R.drawable.alquran, R.raw.alqadr, R.raw.alqadrr));
        allItems.add(new ItemObject("Surah Al-Bayyinah", "٨-١", R.drawable.alquran, R.raw.albayyinahh, R.raw.albayyinah));
        allItems.add(new ItemObject("Surah Az-Zalzalah", "٨-١", R.drawable.alquran, R.raw.azzalzalahh, R.raw.azalzalahh));
        allItems.add(new ItemObject("Surah Al-'Adiyat", "١١-١", R.drawable.alquran, R.raw.aladiyat, R.raw.aladiyatt));
        allItems.add(new ItemObject("Surah Al-Qari'ah", "١١-١", R.drawable.alquran, R.raw.alqariah, R.raw.alqariahh));
        allItems.add(new ItemObject("Surah At-Takasur", "٨-١", R.drawable.alquran, R.raw.attakastur, R.raw.attakatsurr));
        allItems.add(new ItemObject("Surah Al-'Asr", "٣-١", R.drawable.alquran, R.raw.alasr, R.raw.alashr));
        allItems.add(new ItemObject("Surah Al-Humazah", "٩-١", R.drawable.alquran, R.raw.alhumazahh, R.raw.alhumazah));
        allItems.add(new ItemObject("Surah Al-Fil", "٥-١", R.drawable.alquran, R.raw.alfil, R.raw.alfill));
        allItems.add(new ItemObject("Surah Al-Quraysh", "٤-١", R.drawable.alquran, R.raw.alquraisyh, R.raw.quraisy));
        allItems.add(new ItemObject("Surah Al-Ma'un", "٧-١", R.drawable.alquran, R.raw.almaun, R.raw.almaunn));
        allItems.add(new ItemObject("Surah Al-Kaustar", "٣-١", R.drawable.alquran, R.raw.alkautsar, R.raw.alkautsarr));
        allItems.add(new ItemObject("Surah Al-Kafirun", "٦-١", R.drawable.alquran, R.raw.alkafirun, R.raw.alkafirunn));
        allItems.add(new ItemObject("Surah An-Nasr", "٣-١", R.drawable.alquran, R.raw.annashr, R.raw.annasrr));
        allItems.add(new ItemObject("Surah Al-Lahab", "٥-١", R.drawable.alquran, R.raw.allahab, R.raw.allahabb));
        allItems.add(new ItemObject("Surah Al-Ikhlas", "٤-١", R.drawable.alquran, R.raw.alikhlas, R.raw.alikhlass));
        allItems.add(new ItemObject("Surah Al-Falaq", "٥-١", R.drawable.alquran, R.raw.alfalaq, R.raw.alfalaqq));
        allItems.add(new ItemObject("Surah An-Nas", "٦-١", R.drawable.alquran, R.raw.annas, R.raw.annass));

        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem searchItem = menu.findItem(R.id.Cari);
        SearchManager searchManager = (SearchManager)surahPendek.this.getSystemService(Context.SEARCH_SERVICE);

        if (SearchPendek !=null){
            SearchPendek.setIconified(false);

        }
        if (searchItem != null){
            SearchPendek =(SearchView)searchItem.getActionView();

        }
        SearchPendek.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                Toast.makeText(getApplicationContext(), " " + query, Toast.LENGTH_SHORT).show();
                searchedItem.clear();

                for(ItemObject d : allItems){
                    if(d.getName() != null && d.getName().contains(query)) {
                        Log.d("Test", "onQueryTextSubmit: " + d.getName());

                        if(!searchedItem.contains(d))
                            searchedItem.add(d);

                    }
                }

                RecyclerViewAdapter searchedItemAdapter = new RecyclerViewAdapter(getApplicationContext(), searchedItem);
                rView.setAdapter(searchedItemAdapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                List<ItemObject> newList = new ArrayList<>();
                return true;
            }
        });
        return true;
    }

    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this, surahPendek.class));
        finish();
        return true;

    }
}

