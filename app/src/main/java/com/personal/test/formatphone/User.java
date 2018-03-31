package com.personal.test.formatphone;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userName")
    private String userName ;

    @SerializedName("password")
    String password;

    @SerializedName("email")
    String email;


    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
