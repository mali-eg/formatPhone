package com.personal.test.formatphone;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RestClient {


    @POST("/user")
    @Headers("Content-Type: application/json")
    Call<Void> register(@Body User user);


}
