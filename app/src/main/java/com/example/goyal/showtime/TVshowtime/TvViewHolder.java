package com.example.goyal.showtime.TVshowtime;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.goyal.showtime.R;

public class TvViewHolder extends RecyclerView.ViewHolder {
    LinearLayout linearLayout;
    ImageView imageViewTv;
    TextView textViewTv;

    public TvViewHolder(View itemView) {
        super(itemView);
        linearLayout= itemView.findViewById(R.id.linearlayout);
        imageViewTv = itemView.findViewById(R.id.image1);
        textViewTv = itemView.findViewById(R.id.moviename);
    }
}
