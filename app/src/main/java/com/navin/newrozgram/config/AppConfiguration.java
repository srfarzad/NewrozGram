package com.navin.newrozgram.config;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.room.Room;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import io.realm.Realm;

public class AppConfiguration extends Application {

    AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Test").build();

        Realm.init(getApplicationContext());


    }
}
