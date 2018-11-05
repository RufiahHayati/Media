package com.example.rplrus26.media;

import java.util.ArrayList;
import java.util.List;

public class GlobalAlquranDataList {

     public static List<ItemObject> globalAlquranData;
     public static List<ItemObjectHarian> globalSurahHarianData;

     public static void InitialzingData(){
          if (globalAlquranData == null)
               globalAlquranData = InitAlquranData();
          if (globalSurahHarianData == null)
               globalSurahHarianData = InitHarianData();
     }


     static private List<ItemObject> InitAlquranData(){

          List<ItemObject> suratData = new ArrayList<ItemObject>();

          suratData.add(new ItemObject("Surah Al-Fatihah", "٧-١", R.drawable.alquran, R.raw.alfatihah, R.raw.alfatihahh));
          suratData.add(new ItemObject("Surah Ad-Dhuha", "١١-١", R.drawable.alquran, R.raw.addhuha, R.raw.addhuhaa));
          suratData.add(new ItemObject("Surah Al-Insyiroh", "٨-١", R.drawable.alquran, R.raw.alinsyiroh, R.raw.alinsyirohh));
          suratData.add(new ItemObject("Surah At-Tiin", "٨-١", R.drawable.alquran, R.raw.attiin, R.raw.attinn ));
          suratData.add(new ItemObject("Surah Al-'Alaq", "١٩-١", R.drawable.alquran, R.raw.alalaq, R.raw.alalaqq));
          suratData.add(new ItemObject("Surah Al-Qadr", "٥-١", R.drawable.alquran, R.raw.alqadr, R.raw.alqadrr));
          suratData.add(new ItemObject("Surah Al-Bayyinah", "٨-١", R.drawable.alquran, R.raw.albayyinahh, R.raw.albayyinah));
          suratData.add(new ItemObject("Surah Az-Zalzalah", "٨-١", R.drawable.alquran, R.raw.azzalzalahh, R.raw.azalzalahh));
          suratData.add(new ItemObject("Surah Al-'Adiyat", "١١-١", R.drawable.alquran, R.raw.aladiyat, R.raw.aladiyatt));
          suratData.add(new ItemObject("Surah Al-Qari'ah", "١١-١", R.drawable.alquran, R.raw.alqariah, R.raw.alqariahh));
          suratData.add(new ItemObject("Surah At-Takasur", "٨-١", R.drawable.alquran, R.raw.attakastur, R.raw.attakatsurr));
          suratData.add(new ItemObject("Surah Al-'Asr", "٣-١", R.drawable.alquran, R.raw.alasr, R.raw.alashr));
          suratData.add(new ItemObject("Surah Al-Humazah", "٩-١", R.drawable.alquran, R.raw.alhumazahh, R.raw.alhumazah));
          suratData.add(new ItemObject("Surah Al-Fil", "٥-١", R.drawable.alquran, R.raw.alfil, R.raw.alfill));
          suratData.add(new ItemObject("Surah Al-Quraysh", "٤-١", R.drawable.alquran, R.raw.alquraisyh, R.raw.quraisy));
          suratData.add(new ItemObject("Surah Al-Ma'un", "٧-١", R.drawable.alquran, R.raw.almaun, R.raw.almaunn));
          suratData.add(new ItemObject("Surah Al-Kaustar", "٣-١", R.drawable.alquran, R.raw.alkautsar, R.raw.alkautsarr));
          suratData.add(new ItemObject("Surah Al-Kafirun", "٦-١", R.drawable.alquran, R.raw.alkafirun, R.raw.alkafirunn));
          suratData.add(new ItemObject("Surah An-Nasr", "٣-١", R.drawable.alquran, R.raw.annashr, R.raw.annasrr));
          suratData.add(new ItemObject("Surah Al-Lahab", "٥-١", R.drawable.alquran, R.raw.allahab, R.raw.allahabb));
          suratData.add(new ItemObject("Surah Al-Ikhlas", "٤-١", R.drawable.alquran, R.raw.alikhlas, R.raw.alikhlass));
          suratData.add(new ItemObject("Surah Al-Falaq", "٥-١", R.drawable.alquran, R.raw.alfalaq, R.raw.alfalaqq));
          suratData.add(new ItemObject("Surah An-Nas", "٦-١", R.drawable.alquran, R.raw.annas, R.raw.annass));

          return suratData;
     }

     static private List<ItemObjectHarian> InitHarianData() {
          List<ItemObjectHarian> allItemsHarian = new ArrayList<ItemObjectHarian>();
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
}
