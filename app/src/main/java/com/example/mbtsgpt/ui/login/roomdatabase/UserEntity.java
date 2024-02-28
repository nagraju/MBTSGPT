package com.example.mbtsgpt.ui.login.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usersDatabase")
public class UserEntity {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "user_email")
    private String userEmail;

    @ColumnInfo(name = "user_role")
    private String userRole;

    @ColumnInfo(name = "jwt_token")
    private String jwtToken;

    public UserEntity(int uid, String userEmail, String userRole, String jwtToken) {
        this.uid = uid;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.jwtToken = jwtToken;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}

