package com.example.demo_interview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bagwan Akib on 2/4/2020.
 */
public interface APIInterface {

    @GET("photos")
    Call<List<Photo>> getPhotos();

}
