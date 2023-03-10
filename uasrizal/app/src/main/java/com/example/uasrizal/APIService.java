package com.example.uasrizal;

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
    Call<GetDataBarang> AmbilData (

    );

    //deletedatabarang
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/deletebarang.php")
    Call<GetDataBarang> HapusData(
            @Query("kode") String kode
    );

    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/read2.php")
    Call<GetDataSupplier> AmbilDataSupplier (

    );

    //deletedatabarang
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/deletesupplier.php")
    Call<GetDataSupplier> HapusDataSupplier(
            @Query("kode") String kode
    );

    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/read3.php")
    Call<GetDataKaryawan> AmbilDataKaryawan (

    );

    //deletedatabarang
    @Headers("Context-Type:application/json")
    @GET("/androidretrofit/deletekaryawan.php")
    Call<GetDataKaryawan> HapusDataKaryawan(
            @Query("kode") String kode
    );
}
