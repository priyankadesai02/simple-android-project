package com.hackhorizon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hackhorizon.dagger.Restapi;
import com.hackhorizon.model.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getNetComponent().inject(this);

        Call<List<Post>> posts = retrofit.create(Restapi.class).getPosts();

        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                System.err.println("response" + response.message());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                System.err.println("response" + t);
            }
        });
    }

}
