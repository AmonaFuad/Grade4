package com.example.android.grade4.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseClass {


        @SerializedName("items")
    private List <Item> items = null;

    public BaseClass(List <Item> items) {
        this.items = items;
    }

    public List <Item> getItems() {
        return items;
    }


}
