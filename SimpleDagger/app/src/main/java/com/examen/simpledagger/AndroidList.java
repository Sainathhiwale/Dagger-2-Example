package com.examen.simpledagger;

import com.examen.simpledagger.network.model.Android;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AndroidList {
    @SerializedName("android")
    @Expose
    private List<Android> android = null;

    public List<Android> getAndroid() {
        return android;
    }

    public void setAndroid(List<Android> android) {
        this.android = android;
    }

}
