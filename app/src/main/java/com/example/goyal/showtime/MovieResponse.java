package com.example.goyal.showtime;

import java.util.ArrayList;

public class MovieResponse {

    ArrayList<Movie> results;
    ArrayList<Cast> cast;
    public MovieResponse(ArrayList<Movie> results, ArrayList<Cast> cast) {
        this.results = results;
        this.cast = cast;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public ArrayList<Cast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }
}
