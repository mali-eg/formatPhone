package com.personal.test.formatphone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Amazon on 4/1/2018.
 */

public class Credentials {
    @SerializedName("userName")
    private String userName ;

    @SerializedName("password")
    String password;

    public Credentials(){}

    public Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
        this.password = password;
    }
}
