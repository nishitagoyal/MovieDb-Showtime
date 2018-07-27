package com.example.goyal.showtime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

import static android.widget.LinearLayout.HORIZONTAL;
import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

//    RecyclerView recyclerViewtop,recyclerViewpop,recyclerViewupcom,recyclerViewnowplay;
//    MoviesAdapter adapter,adapter1,adapter2,adapter3;
//    ArrayList<Movie> movies0 = new ArrayList<>();
//    ArrayList<Movie> movies1 = new ArrayList<>();
//    ArrayList<Movie> movies2 = new ArrayList<>();
//    ArrayList<Movie> movies3 = new ArrayList<>();
//    Toolbar toolbar;
//    String key = "83a1822d264a2e25a286436acb2b1e12";
//    Call<MovieResponse> call;
private TextView mTextMessage;
private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_Movie:
                mTextMessage.setText("Movie");
                return true;
            case R.id.navigation_TV:
                mTextMessage.setText("TV");
                return true;
            case R.id.navigation_favourite:
                mTextMessage.setText("Favorite");
                return true;
        }
        return false;
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        recyclerViewupcom = findViewById(R.id.upcomrecyclerview);
//         upComing();
//        recyclerViewnowplay = findViewById(R.id.nowplayrecyclerview);
//       nowShowing();
//        recyclerViewtop = findViewById(R.id.topraterecyclerview);
//        topRated();
//        recyclerViewpop = findViewById(R.id.poprecyclerview);
//        popular();
    }
//    public void popular(){
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewpop.setLayoutManager(layoutManager);
//        adapter = new MoviesAdapter(getApplicationContext(),movies0);
//        recyclerViewpop.setAdapter(adapter);
//        MovieServices services = ApiClient.getInstance().create(MovieServices.class);
//        call = services.getMovies("popular",key);
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                MovieResponse movieResponse = response.body();
//                if(movieResponse!=null)
//                {
//                    movies0.clear();
//                    ArrayList<Movie> popmovies= movieResponse.results;
//                    movies0.addAll(popmovies);
//                    adapter.notifyDataSetChanged();
//
//                }
//            }
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Intent intent = new Intent(MainActivity.this,LoadFailActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//    }
//    public void upComing(){
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewupcom.setLayoutManager(layoutManager);
//        adapter1 = new MoviesAdapter(getApplicationContext(),movies1);
//        recyclerViewupcom.setAdapter(adapter1);
//        MovieServices services1 = ApiClient.getInstance().create(MovieServices.class);
//        call = services1.getMovies("upcoming",key);
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                MovieResponse movieResponse = response.body();
//                if(movieResponse!=null)
//                {
//                    movies1.clear();
//                    ArrayList<Movie> upmovies= movieResponse.results;
//                    movies1.addAll(upmovies);
//                    adapter1.notifyDataSetChanged();
//
//                }
//            }
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Intent intent = new Intent(MainActivity.this,LoadFailActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//    }
//    public void nowShowing(){
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewnowplay.setLayoutManager(layoutManager);
//        adapter2 = new MoviesAdapter(getApplicationContext(),movies2);
//        recyclerViewnowplay.setAdapter(adapter2);
//        MovieServices services2 = ApiClient.getInstance().create(MovieServices.class);
//        call = services2.getMovies("now_playing",key);
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                MovieResponse movieResponse = response.body();
//                if(movieResponse!=null)
//                {
//                    movies2.clear();
//                    ArrayList<Movie> nowmovies= movieResponse.results;
//                    movies2.addAll(nowmovies);
//                    adapter2.notifyDataSetChanged();
//
//                }
//            }
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Intent intent = new Intent(MainActivity.this,LoadFailActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//    }
//    public void topRated(){
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewtop.setLayoutManager(layoutManager);
//        adapter3 = new MoviesAdapter(getApplicationContext(),movies3);
//        recyclerViewtop.setAdapter(adapter3);
//        MovieServices services3 = ApiClient.getInstance().create(MovieServices.class);
//        call = services3.getMovies("top_rated",key);
//        call.enqueue(new Callback<MovieResponse>() {
//            @Override
//            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                MovieResponse movieResponse = response.body();
//                if(movieResponse!=null)
//                {
//                    movies3.clear();
//                    ArrayList<Movie> topmovies= movieResponse.results;
//                    movies3.addAll(topmovies);
//                    adapter3.notifyDataSetChanged();
//
//                }
//            }
//            @Override
//            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Intent intent = new Intent(MainActivity.this,LoadFailActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//    }



}
