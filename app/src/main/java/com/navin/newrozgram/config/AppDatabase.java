package com.navin.newrozgram.config;

import android.content.Context;

import com.navin.newrozgram.models.BookRoom;
import com.navin.newrozgram.models.UserRoom;
import com.navin.newrozgram.models.iInterface.DaoRoom;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={UserRoom.class,BookRoom.class} , version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoRoom daoRoom();



    private static volatile AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "Test")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
