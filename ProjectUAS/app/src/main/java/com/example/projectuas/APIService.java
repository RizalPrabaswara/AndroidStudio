package com.example.projectuas;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {
    @Headers("Context-Type:application/json")
    @GET("/pbmuas_18410100131/read.php")
    Call<GetData> AmbilData (

    );

    //insertdata
    @Headers("Context-Type:application/json")
    @GET("/pbmuas_18410100131/insert.php")
    Call<GetData> SimpanData(
            @Query("kode") String kode,
            @Query("nama") String nama,
            @Query("genre") String genre,
            @Query("platform") String platform,
            @Query("harga") String harga,
            @Query("tahun") String tahun
    );

    //updatedata
    @Headers("Context-Type:application/json")
    @GET("/pbmuas_18410100131/update.php")
    Call<GetData> UbahData(
            @Query("kode") String kode,
            @Query("nama") String nama,
            @Query("genre") String genre,
            @Query("platform") String platform,
            @Query("harga") String harga,
            @Query("tahun") String tahun
    );

    //updatedata
    @Headers("Context-Type:application/json")
    @GET("/pbmuas_18410100131/delete.php")
    Call<GetData> HapusData(
            @Query("kode") String kode
    );
}
