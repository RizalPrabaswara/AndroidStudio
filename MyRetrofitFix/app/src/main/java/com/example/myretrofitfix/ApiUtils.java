package com.example.myretrofitfix;

public class ApiUtils {
    private ApiUtils()
    {}
    public static final String BASE_URL="http://192.168.100.7";
    public static APIService getAPIService()
    {
        return Retrofitclient.getClient(BASE_URL).create(APIService.class);
    }
}
