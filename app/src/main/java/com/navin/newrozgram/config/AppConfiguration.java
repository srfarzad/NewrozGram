package com.navin.newrozgram.config;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.room.Room;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.MobileAds;

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

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");


    }
}
