package com.example.rplrus26.media;

import android.support.v4.app.Fragment;

public class Questions extends Fragment {

    public String mQuestions[] = {
            " إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ Apa arti dari Potongan Ayat tersebut ",
            " Apa arti dari penggalan ayat ini مَٰلِكِ",
            "  لَمْ يَلِدْ وَلَمْ يُولَد Apa arti dari potongan ayat tersebut ْ",
            " Apa arti Surah Ad dhuha ?",
            " Apa arti dari ayat tersebut  لَكُمْ دِينُكُمْ وَلِيَ دِينِ",
            " Apa arti Surah Al insyirah ?",
            " Apa arti dari ayat tersebut مِن شَرِّ مَا خَلَقَ",
            " Apa arti Surah al bayyinah?",
            " Apa arti dari ayat tersebut إِنَّا أَعْطَيْنَاكَ الْكَوْثَرَ",
            " Apa arti Surah At tin ?",
            " Apa bacaannya Surah Addhuha ayat 1 ?",
            " Bacaan Latin Surah An Nashr ayat terakhir",


    };



    private String mChoices[][] = {

            {"Hanya Engkaulah yang kami sembah, dan hanya kepada Engkaulah kami meminta pertolongan.", "Tunjukilah kami jalan yang lurus.", "Raja manusia.", "Sembahan manusia."},
            {"hanya kepadamu", "tuhanku", "Pujian", "yang menguasai"},
            {"Katakanlah (wahai Muhammad) bahwa Allah yang Maha Esa." ,"Dia (baca: Allah) tidak beranak dan juga tidak diperanakkan.", "dari jin dan manusia.", "Dari kejahatan (bisikan) setan yang biasa bersembunyi."},
            {"gejolak api" , "waktu matahari sepenggalahan naik", "hal-hal berguna", "kelapangan"},
            {" Katakanlah: Hai orang-orang kafir", "Dan kamu bukan penyembah Tuhan yang aku sembah", "Aku tidak akan menyembah apa yang kamu sembah", "Untukmu agamamu, dan untukkulah, agamaku"},
            {"gejolak api", "waktu subuh", "manusia", "kelapangan"},
            {"serta menghadapi tipu daya kegelapan apabila telah menyelimuti.", "Tunjukilah kami jalan yang lurus.", "menghadapi tipu daya makhluk-makhluk", "yang menguasai"},
            {"nikmat yang banyak", "waktu subuh", "Pembuktian", "kelapangan"},
            {"Sesungguhnya Kami telah memberikan kepadamu nikmat yang banyak." , "Maka dirikanlah shalat karena Tuhanmu dan berkorbanlah.", "dari jin dan manusia.", "menghadapi tipu daya makhluk-makhluk"},
            {"Zaitun", "(buah) Tin"  , "Angur", "Kurma"},
            {"وَالَّيْلِ إِذَا سَجَىٰ " , "وَالضُّحَىٰ" , "فَأَمَّا الْيَتِيْمَ فَلَا تَقْهَرْ" , "وَوَجَدَكَ عَآئِلًا فَأَغْنَىٰ"},
            {"فَسَبِّحْ بِحَمْدِ رَبِّكَ وَاسْتَغْفِرْهُ ۚ إِنَّهٗ كَانَ تَوَّابًا", "idzaa jaa-a nashrullaahi wal fath", "innal insaana lafii khusr", "Fasabbih bihamdi robbika wastaghfir. Innahu kaana tawwaabaa."},
    };

    private String mCorrectAnswers[] = { "Hanya Engkaulah yang kami sembah, dan hanya kepada Engkaulah kami meminta pertolongan.", "yang menguasai", "Dia (baca: Allah) tidak beranak dan juga tidak diperanakkan." , "waktu matahari sepenggalahan naik" , "Untukmu agamamu, dan untukkulah, agamaku",
            "kelapangan","menghadapi tipu daya makhluk-makhluk" ,"Pembuktian", "Sesungguhnya Kami telah memberikan kepadamu nikmat yang banyak." , "(buah) Tin" , "وَالضُّحَىٰ", "Fasabbih bihamdi robbika wastaghfir. Innahu kaana tawwaabaa."};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
