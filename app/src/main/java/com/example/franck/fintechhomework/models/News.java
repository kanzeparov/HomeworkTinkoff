
package com.example.franck.fintechhomework.models;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("payload")
    @Expose
    private ArrayList<Payload> payload = null;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public ArrayList<Payload> getPayload() {
        return payload;
    }

    public void setPayload(ArrayList<Payload> payload) {
        this.payload = payload;
    }

}
