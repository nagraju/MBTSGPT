package com.example.mbtsgpt.utils;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mbtsgpt.R;
import com.example.mbtsgpt.api.RetrofitBuilder;
import com.example.mbtsgpt.model.JwtResponse;
import com.example.mbtsgpt.model.JwtUserRequest;
import com.example.mbtsgpt.ui.login.roomdatabase.UserDao;
import com.example.mbtsgpt.ui.login.roomdatabase.UserEntity;

import java.util.Set;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Authentication extends RetrofitBuilder {
        private Context appContext;
        private JwtUserRequest user;
        private Context context;
        private NavController findNavController;

        public Authentication(JwtUserRequest user, Context context, NavController findNavController) {
            this.user = user;
            this.context = context;
            this.findNavController = findNavController;
            this.appContext = context.getApplicationContext();
        }

        public String authenticate() {
            Call<JwtResponse> retrofitData = retrofitBuilder.loginUser(user);
            String state = null;



            retrofitData.enqueue(new Callback<JwtResponse>() {
                @Override
                public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
                    String userEmail;
                    String jwtToken;
                    JwtResponse userDetails= response.body();
                    String userRole ;
                    if (userDetails != null && userDetails.getResponseUser() != null) {
                        Toast.makeText(context, "Well Come " + userDetails.getResponseUser().getUsername(), Toast.LENGTH_SHORT).show();
                        userEmail = userDetails.getResponseUser().getUsername();
                        userRole = userDetails.getResponseUser().getRole();
                        jwtToken = userDetails.getJwtToken();
                        AppDatabase result = AppDatabase.getAppDatabase(context);
                        UserDao userDao = result.userDao();
                        if (saveInDatabase(userEmail, userRole, jwtToken, userDao).equals("done")) {
                                findNavController.navigate(R.id.action_login_to_nav_home);
                        }
                    } else {
                        System.out.println(userDetails);
                        Toast.makeText(context, "Invalid user name or password", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<JwtResponse> call, Throwable t) {
                    findNavController.navigate(R.id.action_login_to_connetion_error, new Bundle());
                }
            });


            return String.valueOf(state);
        }


    public String saveInDatabase(String userEmail, String userRole, String jwtToken, UserDao userDao) {
        userDao.deleteLastUser();
        UserEntity obj = new UserEntity(1, userEmail, userRole, jwtToken);
        userDao.insertUser(obj);
        UserEntity users = userDao.getUser();
        return "done";
    }
}

@Database(entities = {UserEntity.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "usersDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}