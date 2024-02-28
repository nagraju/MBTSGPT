package com.example.mbtsgpt.ui.login.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class ResponseUserDetails {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "user_email")
    private String userEmail;

    @ColumnInfo(name = "user_role")
    private String userRole;

    @ColumnInfo(name = "jwt_token")
    private String jwtToken;

    public ResponseUserDetails(int uid, String userEmail, String userRole, String jwtToken) {
        this.uid = uid;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.jwtToken = jwtToken;
    }

    // Getters and setters for each field

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

