package com.navin.newrozgram.models.iInterface;

import com.navin.newrozgram.models.UserRoom;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DaoRoom {

    @Query("select * from UserRoom ")
    public List<UserRoom> getUserRoomList();

    @Insert
    void insert(UserRoom...user);

    @Delete
    void delete(UserRoom user);

}
