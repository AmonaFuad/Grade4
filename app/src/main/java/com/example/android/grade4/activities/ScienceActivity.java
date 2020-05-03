package com.example.android.grade4.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.grade4.R;
import com.example.android.grade4.adapter.CustomAdapter;
import com.example.android.grade4.adapter.RecycleViewClickable;
import com.example.android.grade4.models.BaseClass;
import com.example.android.grade4.models.Item;
import com.example.android.grade4.rest.ApiClient;
import com.example.android.grade4.rest.SienceSirver;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceActivity extends YouTubeBaseActivity implements RecycleViewClickable {
    private RecyclerView mRecyclerView;
    CustomAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    ArrayList <BaseClass> myDataSource = new ArrayList <BaseClass>();
    ArrayList <Item> items= new ArrayList <>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        mRecyclerView= findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new CustomAdapter( items,this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        loadData();
    }
    public void loadData()
    {
        final SienceSirver apiService =
                ApiClient.getClient().create(SienceSirver.class);
        Call <BaseClass> call = apiService.getUser();
        call.enqueue(new Callback <BaseClass>() {
            @Override
            public void onResponse(Call <BaseClass> call, Response <BaseClass> response) {
                myDataSource.clear();
                items.addAll(response.body().getItems());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call <BaseClass> call, Throwable t) {
                Toast.makeText(ScienceActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public void onMyAdapterClick(int itemPosition) {
        Intent intent = new Intent(ScienceActivity.this, VideoPlayAcyivity.class);
        String message = items.get(itemPosition).getSnippet().getResourceId().getVideoId();
        intent.putExtra("EXTRA_MESSAGE", message);
        startActivity(intent);
    }

    @Override
    public void onMyAdapterLongClick(int itemPosition) {

    }
}
