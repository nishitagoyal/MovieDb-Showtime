package com.example.goyal.showtime;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieServices {
    @GET("movie/{movie_type}")
    Call<MovieResponse> getMovies(@Path("movie_type") String type, @Query("api_key") String key);
    @GET("movie/{movie_id}/casts")
    Call<MovieResponse> getDetails(@Path("movie_id") int id,@Query("api_key") String key);
    @GET("movie/{movie_id}/videos")
    Call<TrailerResponse> getTrailer(@Path("movie_id") int id,@Query("api_key") String key);
    @GET("person/{person_id}")
    Call<MovieResponse> getCastDetails(@Path("person_id") int cast_id,@Query("api_key") String key);
    @GET("person/{person_id}/movie_credits")
    Call<MovieResponse> getCastMovies(@Path("person_id") int cast_id,@Query("api_key") String key);
    @GET("person/{person_id}/tv_credits")
    Call<MovieResponse> getCastTv(@Path("person_id") int cast_id,@Query("api_key") String key);
}
