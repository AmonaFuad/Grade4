package com.example.android.grade4.rest;

import com.example.android.grade4.models.BaseClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SocialServer {
    @GET("youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLIPYb0kAOAourwg4KhqsQ7zVeSp0JFuKu&key=AIzaSyBycHSTLwxyUVTGp92OwRQnY-asmpGNnM8")
    Call <BaseClass> getUser();
}
