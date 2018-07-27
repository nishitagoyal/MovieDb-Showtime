package com.example.goyal.showtime;

import com.google.gson.annotations.SerializedName;

public class Movie {
    public int id;
    @SerializedName("title")
   private String title;
   private String video;
   @SerializedName("poster_path")
   private String poster_path;
   private String overview;
   private String release_date;
   private int vote_count;
   private double vote_average;
   private String original_language;
   private String backdrop_path;
   private String adult;

    public Movie(int id, String title, String video, String poster_path, String overview, String release_date, int vote_count, double vote_average, String original_language, String backdrop_path, String adult) {
        this.id = id;
        this.title = title;
        this.video = video;
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.original_language = original_language;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setVideo(String video)
    {
        this.video = video;
    }

    public void setPoster_path(String poster_path)
    {
        this.poster_path = poster_path;
    }

    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVideo() {
        return video;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
