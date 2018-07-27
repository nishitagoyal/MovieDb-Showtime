package com.example.goyal.showtime.TVshowtime;

import com.example.goyal.showtime.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TvServices {
    @GET("tv/{tv_type}")
    Call<MovieResponse> getTv(@Path("tv_type") String type, @Query("api_key") String key);
}
