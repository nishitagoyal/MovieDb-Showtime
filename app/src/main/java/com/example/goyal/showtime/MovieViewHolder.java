package com.example.goyal.showtime;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    LinearLayout linearLayout;
    ImageView imageView;
     TextView textView,textView1;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        linearLayout= itemView.findViewById(R.id.linearlayout);
        textView = itemView.findViewById(R.id.moviename);
        textView1 = itemView.findViewById(R.id.vote);
        imageView = itemView.findViewById(R.id.image1);

    }
}
