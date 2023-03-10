package com.example.uasrizal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDataBarang {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("data")
    @Expose
    private List<DataBarang> data = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataBarang> getData() {
        return data;
    }

    public void setData(List<DataBarang> data) {
        this.data = data;
    }
}
