package com.example.demo_interview;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bagwan Akib on 2/4/2020.
 */
public class Photo {

    @SerializedName("albumId")
    int albumId;

    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("thumbnailUrl")
    String thumbnailUrl;

    @SerializedName("url")
    String url;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }
}
