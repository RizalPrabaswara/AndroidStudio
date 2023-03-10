package com.example.projectuas;

public class ApiUtils {
    private ApiUtils()
    {}
    public static final String BASE_URL="http://192.168.100.2";
    public static APIService getAPIService()
    {
        return Retrofitclient.getClient(BASE_URL).create(APIService.class);
    }
}
