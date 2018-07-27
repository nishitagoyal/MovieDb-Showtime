package com.example.goyal.showtime;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

import retrofit2.Callback;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder>{

    ArrayList<Movie> movies;
    Context context;

    public MoviesAdapter(Context context,ArrayList<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View rowLayout = inflater.inflate(R.layout.recyclerview_layout,viewGroup,false);
         return new MovieViewHolder(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        int position= movieViewHolder.getAdapterPosition();
        final Movie movie = movies.get(position);
        double vote_avg = movie.getVote_average()*10;
        movieViewHolder.textView.setText(movie.getTitle());
        new Picasso.Builder(context)
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.d("lalala",exception.getMessage());
                    }
                }).build()
                .load("http://image.tmdb.org/t/p/w780" + movie.getPoster_path())
                .into(movieViewHolder.imageView);
        movieViewHolder.textView1.setText(vote_avg + "%");
        movieViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("id",movie.getId());
                intent.putExtra("poster","http://image.tmdb.org/t/p/w780" + movie.getPoster_path());
                intent.putExtra("title",movie.getTitle());
                intent.putExtra("overview",movie.getOverview());
                intent.putExtra("releasedate",movie.getRelease_date());
                intent.putExtra("language",movie.getOriginal_language());
                intent.putExtra("adult",movie.getAdult());
                intent.putExtra("backdrop","http://image.tmdb.org/t/p/w780" + movie.getBackdrop_path());
//                intent.putExtra("video",movie.getVideo());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
