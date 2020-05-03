package com.example.android.grade4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.grade4.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoPlayAcyivity extends YouTubeBaseActivity {
    YouTubePlayer.OnInitializedListener onInitializedListener;
    private String apiKey = "AIzaSyATNcXEQldlxb7SnZC-q7Rwz9MGAgapQyI";
    Bundle extras;
    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play_acyivity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play_acyivity);

        extras = getIntent().getExtras();
        newString = extras.getString("EXTRA_MESSAGE");

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo(newString);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        YouTubePlayerView videoPlayer = findViewById(R.id.videoPlay);
        videoPlayer.initialize(apiKey, onInitializedListener);

    }
}
