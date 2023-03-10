package com.example.myretrofitfix;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface APIService {
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/read.php")
    Call<GetData> AmbilData (

    );

    //insertdata
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/insert.php")
    Call<GetData> SimpanData(
        @Query("kode") String kode,
        @Query("nama") String nama,
        @Query("alamat") String alamat
    );

    //updatedata
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/update.php")
    Call<GetData> UbahData(
            @Query("kode") String kode,
            @Query("nama") String nama,
            @Query("alamat") String alamat
    );

    //hapusdata
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/delete.php")
    Call<GetData> HapusData(
            @Query("kode") String kode
    );

    //uploadfoto
    @Multipart
    @POST("/androidretrofit/upload.php")
    Call<GetDataFoto> UploadFoto(
            @Part MultipartBody.Part photo,
            @PartMap Map<String, RequestBody> text,
            @Query("caption") String caption
            );
}
