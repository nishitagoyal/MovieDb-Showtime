package com.example.goyal.showtime;

import java.util.ArrayList;

public class TrailerResponse {
    ArrayList<Trailer> results;

    public TrailerResponse(ArrayList<Trailer> results) {
        this.results = results;
    }

    public ArrayList<Trailer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Trailer> results) {
        this.results = results;
    }
}
