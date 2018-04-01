package com.personal.test.formatphone;

/**
 * Created by Amazon on 4/1/2018.
 */

public class Token {

    private String accessToken;

    public Token(){}

    public Token(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {

        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
