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

public class DetailAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    ArrayList<Cast> casts;
    Context context;
    public DetailAdapter(ArrayList<Cast> casts, Context context) {
        this.casts = casts;
        this.context = context;

    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowLayout = inflater.inflate(R.layout.detailrecyclerview_layout,parent,false);
        return new MovieViewHolder(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int id) {
        final Cast cast=casts.get(id);
        holder.textView.setText(cast.getName());
        new Picasso.Builder(context)
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.d("lalala",exception.getMessage());
                    }
                }).build()
                .load("http://image.tmdb.org/t/p/w780" + cast.getProfile_path())
                .into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context,CastActivity.class);
                intent1.putExtra("id",cast.getCast_id());
                context.startActivity(intent1
                );
            }
        });
    }



    @Override
    public int getItemCount() {
        return casts.size();
    }
}
