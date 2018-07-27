package com.example.goyal.showtime.TVshowtime;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goyal.showtime.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvViewHolder>{
    ArrayList<Result> results;
    Context context;

    public TvAdapter(ArrayList<Result> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowLayout = inflater.inflate(R.layout.recyclerview_layout,parent,false);
        return new TvViewHolder(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        int i= holder.getAdapterPosition();
        Result result = results.get(i);
        holder.textViewTv.setText(result.getName());
        new Picasso.Builder(context)
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.d("lalala",exception.getMessage());
                    }
                }).build()
                .load("http://image.tmdb.org/t/p/w780" + result.getPosterPath())
                .into(holder.imageViewTv);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
