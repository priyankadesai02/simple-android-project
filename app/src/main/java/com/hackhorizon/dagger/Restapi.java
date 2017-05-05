package com.hackhorizon.dagger;

import com.hackhorizon.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Restapi {

    @GET("/posts")
    Call<List<Post>> getPosts();
}