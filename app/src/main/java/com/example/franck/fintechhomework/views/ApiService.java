package com.example.franck.fintechhomework.views;


import com.example.franck.fintechhomework.models.News;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Franck on 27.11.2017.
 */

public interface ApiService {

    @GET("/v1/news/")
    Call<News> getMyJSON();

}


