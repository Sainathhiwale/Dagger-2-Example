package com.examen.simpledagger.network;

import com.examen.simpledagger.network.model.Android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("Activities")
    Call<List<Android>> getAndroidLst();

}
