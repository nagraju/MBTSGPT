package com.example.mbtsgpt.ui.login.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("SELECT * FROM usersDatabase")
    UserEntity getallUser();
    @Query("SELECT * FROM usersDatabase LIMIT 1")
    UserEntity getUser();

    @Insert
    void insertUser(UserEntity... users);

    @Delete
    void deleteUser(UserEntity user);

    @Query("DELETE FROM usersDatabase WHERE uid = 1")
    void deleteLastUser();
}

