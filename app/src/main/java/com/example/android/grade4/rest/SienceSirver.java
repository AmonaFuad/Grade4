package com.example.android.grade4.rest;

import com.example.android.grade4.models.BaseClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SienceSirver {
    @GET("youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLIPYb0kAOAovIg7Dg1TIISEDHAam716I8&key=AIzaSyATNcXEQldlxb7SnZC-q7Rwz9MGAgapQyI")
    Call <BaseClass> getUser();
}
