package com.navin.newrozgram.models;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Book extends SugarRecord {

    @Unique
    int id;
    String name;

    public Book(){

    }

    public Book(int id , String name) {
        this.id = id;
        this.name = name;
    }
}
