package com.example.myretrofit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/read.php")
    Call<GetData> AmbilData (

            );
}
