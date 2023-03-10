package com.example.myretrofit;


public class ApiUtils {
    private ApiUtils()
    {}
    public static final String BASE_URL="http://192.168.100.4/";
    public static APIService getAPIService()
    {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }


}
