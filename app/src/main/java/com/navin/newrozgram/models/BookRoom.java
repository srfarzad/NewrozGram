package com.navin.newrozgram.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BookRoom {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "book_name")
    public String bookName;

}
