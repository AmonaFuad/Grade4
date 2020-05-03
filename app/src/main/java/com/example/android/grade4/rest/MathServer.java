package com.example.android.grade4.rest;

import com.example.android.grade4.models.BaseClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MathServer {
    @GET("youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLIPYb0kAOAot3R-XkGKw9VQbfduIPPlDr&key=AIzaSyBycHSTLwxyUVTGp92OwRQnY-asmpGNnM8")
    Call <BaseClass> getUser();
}
