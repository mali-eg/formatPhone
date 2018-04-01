package com.personal.test.formatphone;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestClient {


    @POST("/user")
    @Headers("Content-Type: application/json")
    Call<Void> register(@Body User user);

    @GET("/user/{id}")
    @Headers("Content-Type: application/json")
    Call<User> getUser(@Path("id") long userId);

    @POST("/token")
    @Headers("Content-Type: application/json")
    Call<Token> login(@Body Credentials credentials);


}
