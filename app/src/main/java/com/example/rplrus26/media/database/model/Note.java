package com.example.rplrus26.media.database.model;

public class Note {
    public static final String TABLE_NAME = "notes";

    public static final String TYPE = "type";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_RESWEB = "resweb";

    private int id;
    private int type;
    private String note;
    private String name;
    private String timestamp;
    private String resweb;



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + TYPE + " INTEGER,"
                    + COLUMN_NOTE + " TEXT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + COLUMN_RESWEB + " TEXT"
                    + ")";

    public Note() {
    }

    public Note(int id, String note, String timestamp, int type) {
        this.id = id;
        this.note = note;
        this.setType(type);
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getResweb() {
        return resweb;
    }

    public void setResweb(String resweb) {
        this.resweb = resweb;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
