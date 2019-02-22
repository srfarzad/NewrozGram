package com.navin.newrozgram.models;

import com.orm.dsl.Unique;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserRoom {

    @Unique
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    public String lastName;
}
