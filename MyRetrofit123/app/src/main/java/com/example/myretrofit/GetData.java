package com.example.myretrofit;

import java.util.List;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetData {
    @Expose
    public String status;
    @Expose
    private List<DataProfil> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataProfil> getData() {
        return data;
    }

    public void setData(List<DataProfil> data) {
        this.data = data;
    }
}
