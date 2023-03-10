package com.example.projectuas;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetData {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("data")
    @Expose
    private List<DataUAS> data = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataUAS> getData() {
        return data;
    }

    public void setData(List<DataUAS> data) {
        this.data = data;
    }
}
