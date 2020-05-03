package com.example.android.grade4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.grade4.R;
import com.example.android.grade4.models.Item;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ExampleViewHolder> {
    private static final String TAG = "CustomAdapter";
    private static String apiKey = "AIzaSyATNcXEQldlxb7SnZC-q7Rwz9MGAgapQyI";
    private ArrayList <Item> mVideoItems;
    private RecycleViewClickable recycleViewClickable;
    public CustomAdapter(ArrayList <Item> videoItems,RecycleViewClickable recycleViewClickable){
        mVideoItems=videoItems;
        this.recycleViewClickable=recycleViewClickable;
    }


    public static  class ExampleViewHolder extends RecyclerView.ViewHolder {
        public com.google.android.youtube.player.YouTubeThumbnailView thumbnailView;
        public TextView titleTextView;

        // RecycleViewClickable recycleViewClickable;
        public ExampleViewHolder(@NonNull View itemView, final RecycleViewClickable recycleViewClickable) {
            super(itemView);
            thumbnailView =itemView.findViewById(R.id.thumpView);
            titleTextView= itemView.findViewById(R.id.video_title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recycleViewClickable.onMyAdapterClick(getAdapterPosition());
                }
            });

        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view,recycleViewClickable);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        final Item getVideoData=mVideoItems.get(position);
        holder.titleTextView.setText(getVideoData.getSnippet().getTitle());
       holder.thumbnailView.initialize(apiKey, new YouTubeThumbnailView.OnInitializedListener() {
           @Override
           public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
               youTubeThumbnailLoader.setVideo(getVideoData.getSnippet().getResourceId().getVideoId());

               youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                   @Override
                   public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                       youTubeThumbnailLoader.release();
                   }

                   @Override
                   public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                   }
               });

           }

           @Override
           public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

           }
       });


    }
//////////////

    @Override
    public int getItemCount() {
        return mVideoItems.size();
    }
}
