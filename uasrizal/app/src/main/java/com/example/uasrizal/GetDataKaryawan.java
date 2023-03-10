package com.example.uasrizal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDataKaryawan {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("data")
    @Expose
    private List<DataKaryawan> data = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataKaryawan> getData() {
        return data;
    }

    public void setData(List<DataKaryawan> data) {
        this.data = data;
    }
}
