package com.example.rplrus26.media;

import android.os.Parcel;
import android.os.Parcelable;


public class ItemObject implements Parcelable {

    public int id;
    private String name;
    private String ayat;
    private int resWeb;
    private int logoid;
    private int audioData;


    protected ItemObject(Parcel in) {
        id = in.readInt();
        name = in.readString();
        ayat = in.readString();
        resWeb = in.readInt();
        logoid = in.readInt();
        audioData = in.readInt();
    }

    public static final Parcelable.Creator<ItemObject> CREATOR = new Parcelable.Creator<ItemObject>() {
        @Override
        public ItemObject createFromParcel(Parcel in) {
            return new ItemObject(in);
        }

        @Override
        public ItemObject[] newArray(int size) {
            return new ItemObject[size];
        }
    };


    public int getId() {
        return id;
    }

    public ItemObject(String name, String ayat, int logoid, int resHTML, int audioDataRes) {
        this.setName(name);
        this.setAyat(ayat);
        this.setLogoid(logoid);
        this.resWeb = resHTML;
        this.audioData = audioDataRes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public int getLogoid() {
        return logoid;
    }

    public void setLogoid(int logoid) {
        this.logoid = logoid;
    }

    public int getResWeb() {
        return resWeb;
    }

    public void setResWeb(int resWeb) {
        this.resWeb = resWeb;
    }

    public int getAudioData() {
        return audioData;
    }

    public void setAudioData(int audioData) {
        this.audioData = audioData;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
        public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(ayat);
        parcel.writeInt(resWeb);
        parcel.writeInt(logoid);
        parcel.writeInt(audioData);
    }
}
