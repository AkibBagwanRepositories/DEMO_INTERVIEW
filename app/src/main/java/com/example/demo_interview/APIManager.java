package com.example.demo_interview;

import java.util.List;

/**
 * Created by Bagwan Akib on 2/4/2020.
 */
public class APIManager {
    public static List<Photo> getListOfPhotos() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        return Executor.execute(apiInterface.getPhotos());
    }
}
