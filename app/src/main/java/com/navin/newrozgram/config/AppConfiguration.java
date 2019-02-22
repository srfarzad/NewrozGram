package com.navin.newrozgram.config;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.room.Room;
import io.realm.Realm;

public class AppConfiguration extends Application {

    AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Test").build();

        Realm.init(getApplicationContext());


    }
}
