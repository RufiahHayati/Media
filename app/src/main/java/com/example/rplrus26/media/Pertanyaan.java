package com.example.rplrus26.media;

import android.support.v4.app.Fragment;

public class Pertanyaan extends Fragment {

    public String mPertanyaan[] = {
            "Apa nama Doa tersebut  اللَّهُمَّ افْتَحْ لِيْ أَبْوَابَ رَحْمَتِكَ",
            "Apa nama Doa tersebut بِسْمِ اللَّهِ ، تَوَكَّلْتُ عَلَى اللَّهِ ، وَلا حَوْلَ وَلا قُوَّةَ إِلاَّ بِاللَّهَ",
            "Apa nama Doa tersebut  اَلْحَمْدُ ِللهِ الَّذِى أَحْيَانَا بَعْدَمَا أَمَاتَنَا وَإِلَيْهِ النُّشُورَُ",
            "Apa nama Doa tersebut  اَللَّهُـمَّ كَمَا حَسَّـنْتَ خَلْقِـيْ فَحَسِّـنْ خُلُقِـيَْ",
            "Apa nama Doa tersebut  بِسْمِ اللهِ الَّذِيْ لاَ إِلَهَ إِلَّا هُوََ",
            "Apa nama Doa tersebut  اَللّهُمَّ اغْفِرْلِيْ وَلِوَالِدَيَّ وَارْحَمْهُمَاكَمَارَبَّيَانِيْ صَغِيْرَاَ",
            "Apa nama Doa tersebut  اَللّهُمَّ اِنىِّ اَعُوْذُ بِكَ مِنَ الْخُبُثِ وَ الْخَبَائِثَِ",
            "Apa nama Doa tersebut  سُبْحَانَ الَّذِىْ سَخَّرَلَنَا هَذَا وَمَاكُنَّالَهُ مُقْرِنِيْنَ وَاِنَّآ اِلَى رَبِّنَا لَمُنْقَلِبُوْنََ",
            "Apa nama Doa tersebut  رَبَّنَا اٰتِنَا فِى الدُّنْيَا حَسَنَةً وَّفِى اْلاٰخِرَةِ حَسَنَةً وَّقِنَا عَذَابَ النَّارَِ",
            "Apa nama Doa tersebut  اَللّهُمَّ لَكَ صُمْتُ وَبِكَ آمَنْتُ وَعَلَى رِزْقِكَ أَفْطَرْتُ بِرَحْمَتِكَ يَا اَرْحَمَ الرَّحِمِيْنََ",
            "Apa bunyi nya Doa Sesudah makan",
            "Apa bunyi nya Doa Sebelum makan",
            "Apa bunyi nya Doa sebelum tidur",
            "Do'a Untuk Orang yang Mendengar Bersin",

    };

    private String mPilihan[][] = {
            {"Doa masuk wc", "Doa masuk masjid", "Doa naik kendaraan", "Doa istinja'"},
            {"Doa sebelum belajar", "Doa sebelum makan ", "Doa ditimpa musibah", "Doa keluar rumah"},
            {"Doa keluar rumah", "Doa bangun tidur", "Doa ketika hujan", "Doa bersin "},
            {"Doa keluar wc", "Doa berbuka puasa", "Doa bercermin", "Doa berpakaian"},
            {"Doa melepas pakaian", "Doa sesudah makan", "Doa keluar masjid", "Doa kebaikan kedua orang tua "},
            {"Doa ditimpa musibah", "Doa istinja'", "Doa kebaikan kedua orang tua", "Doa masuk masjid"},
            {"Doa becermin", "Doa bangun tidur", "Doa masuk rumah", "Doa masuk wc"},
            {"Doa bersin", "Doa keluar rumah", "Doa naik kendaraan", "Doa sebelum belajar"},
            {"Doa berbuka puasa", "Doa melepas pakaian", "Doa kebaikan dunia akhirat", "Doa kebaikan kedua orang tua"},
            {"Doa ketika hujan", "Doa berbuka puasa", "Doa bersin", "Doa sesudah makan'"},
            {"اَلْحَمْدُ ِللهِ الَّذِيْنَ اَطْعَمَنَا وَسَقَانَا وَجَعَلَنَا مِنَ الْمُسْلِمِيْنَ", "الَّلهُمَّ بَارِكْ لَنَا فِيمَا رَزَقْتَنَا، وَقِنَا عَذَابَ النَّارِ", "بِسْمِ اللهِ الَّذِيْ لاَ إِلَهَ إِلَّا هُو", "اَلْحَمْدُ ِللهِ الَّذِى أَحْيَانَا بَعْدَمَا أَمَاتَنَا وَإِلَيْهِ النُّشُور"},
            {"بِسْمِكَ اللّهُمَّ اَحْيَا وَ بِسْمِكَ اَمُوْتُ", "الَّلهُمَّ بَارِكْ لَنَا فِيمَا رَزَقْتَنَا، وَقِنَا عَذَابَ النَّار", "اَللّهُمَّ اِنِّيْ أسْأَلُكَ مِنْ فَضْلِكَ.", "اللَّهُمَّ افْتَحْ لِيْ أَبْوَابَ رَحْمَتِك"},
            {"بِسْمِ اللَّهِ ، تَوَكَّلْتُ عَلَى اللَّهِ ، وَلا حَوْلَ وَلا قُوَّةَ إِلاَّ بِاللَّه", "بِسْمِ اللهِ وَلَجْنَا وَبِسْمِ اللهِ خَرَجْنَا ، وَعَلَى اللهِ رَبَّنَا تَوَكَّلْنَا ", "بِسْمِ اللَّهِ ، تَوَكَّلْتُ عَلَى اللَّهِ ، وَلا حَوْلَ وَلا قُوَّةَ إِلاَّ بِاللَّهَ", "بِسْمِكَ اللّهُمَّ اَحْيَا وَ بِسْمِكَ اَمُوْت"},
            {"اَللّهُمَّ اِنِّيْ أسْأَلُكَ مِنْ فَضْلِكَ", "يَرْحَمُكَ الله ", "بِسْمِ اللهِ الَّذِيْ لاَ إِلَهَ إِلَّا هُوَ", "اَلْحَمْدُ ِلله"}
    };

    private String mJawabPilihan[] = {"Doa masuk masjid" , "Doa keluar rumah" , "Doa bangun tidur", "Doa bercermin", "Doa melepas pakaian",
    "Doa kebaikan kedua orang tua", "Doa masuk wc", "Doa naik kendaraan", "Doa kebaikan dunia akhirat", "Doa berbuka puasa", "اَلْحَمْدُ ِللهِ الَّذِيْنَ اَطْعَمَنَا وَسَقَانَا وَجَعَلَنَا مِنَ الْمُسْلِمِيْنَ" , "الَّلهُمَّ بَارِكْ لَنَا فِيمَا رَزَقْتَنَا، وَقِنَا عَذَابَ النَّار", "بِسْمِكَ اللّهُمَّ اَحْيَا وَ بِسْمِكَ اَمُوْتُ", "يَرْحَمُكَ الله "};

    public String getPertanya(int a){
        String question = mPertanyaan[a];
        return question;
    }

    public String getPilih1(int a){
        String choice = mPilihan[a][0];
        return choice;
    }

    public String getPilih2(int a){
        String choice = mPilihan[a][1];
        return choice;
    }

    public String getPilih3(int a){
        String choice = mPilihan[a][2];
        return choice;
    }

    public String getPilih4(int a){
        String choice = mPilihan[a][3];
        return choice;
    }

    public String getJawabPilih(int a){
        String answer = mJawabPilihan[a];
        return answer;
    }
}
