package com.example.demo_interview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Bagwan Akib on 2/4/2020.
 */
public class Executor {
    public static List<Photo> execute(Call<List<Photo>> call) {
        try {
            Response<List<Photo>> response = call.execute();
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
