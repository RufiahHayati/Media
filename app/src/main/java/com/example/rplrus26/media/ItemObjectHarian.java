package com.example.rplrus26.media;

public class ItemObjectHarian {
    private String name;
    private int resWeb;
    private int logoid;
    private int audioData;

    public ItemObjectHarian(String name, int logoid, int resHTML1, int audioDataRes) {
        this.setName(name);
        this.setLogoid(logoid);
        this.resWeb = resHTML1;
        this.audioData = audioDataRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
