package com.example.mbtsgpt.utils;


import android.content.Context;
import androidx.room.Room;
import com.example.mbtsgpt.ui.login.roomdatabase.*;


public class GetUserDetails {
    //get user details
    public ResponseUserDetails getData(Context context) {
        Context appContext = context.getApplicationContext();
        AppDatabase db = Room.databaseBuilder(
                appContext,
                AppDatabase.class, "usersDatabase"
        ).allowMainThreadQueries().build();
        UserDao userDao = db.userDao();
        UserEntity user = userDao.getUser();
        return new ResponseUserDetails(
                user.getUid(),
                user.getUserEmail(),
                user.getUserRole(),
                user.getJwtToken()
        );
    }
}

