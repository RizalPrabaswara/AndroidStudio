package com.example.myretrofitfix;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetData {
    @SerializedName("result")
    @Expose
    public String result;
    @SerializedName("data")
    @Expose
    private List<DataUser> data = null;

    public String getResult() {

        return result;
    }

    public void setResult(String result) {

        this.result = result;
    }

    public List<DataUser> getData() {

        return data;
    }

    public void setData(List<DataUser> data) {

        this.data = data;
    }
}
