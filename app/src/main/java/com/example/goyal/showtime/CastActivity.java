package com.example.goyal.showtime;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CastActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    RecyclerView recyclerViewmoviecast,recyclerViewtvcast;
    TextView textView1,textView2,textView3,textView4;
    ImageView imageview;
    int id;
    Call<MovieResponse> call2;
    String key = "83a1822d264a2e25a286436acb2b1e12";
    CastDetail adapter1;
    ArrayList<CastDetail> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast);
        relativeLayout = findViewById(R.id.castlayout);
        textView1 = findViewById(R.id.name);
        textView2 = findViewById(R.id.alsoknownas);
        textView3 = findViewById(R.id.popularity);
        textView4 = findViewById(R.id.birthday);
        imageview = findViewById(R.id.castpic);
        Intent intent1=getIntent();
        if(intent1.hasExtra("id")){
             id= intent1.getIntExtra("id",0);
            MovieServices services = ApiClient.getInstancecast().create(MovieServices.class);
            call2 = services.getDetails(id,key);
            call2.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call2, Response<MovieResponse> response) {
                    MovieResponse movieResponse = response.body();

                    if (movieResponse != null)
                    {
                        CastDetail castDetail = new CastDetail();
                        textView2.setText((CharSequence) castDetail.getAlsoKnownAs());
                        textView1.setText(castDetail.getName());
                        new Picasso.Builder(CastActivity.this)
                                .listener(new Picasso.Listener() {
                                    @Override
                                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                                        Log.d("lalala",exception.getMessage());
                                    }
                                }).build()
                                .load("http://image.tmdb.org/t/p/w780" + castDetail.getProfilePath())
                                .into(imageview);
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call2, Throwable t) {

                }
            });

        }

        recyclerViewmoviecast = findViewById(R.id.castmovies);
        castMovie();
        recyclerViewtvcast = findViewById(R.id.casttv);
        castTv();

    }
    public void castMovie(){

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewmoviecast.setLayoutManager(layoutManager);
//        adapter1 = new TrailerAdapter(getApplicationContext(),trailers);
//        recyclerViewtrailer.setAdapter(adapter1);
//        MovieServices services = ApiClient.getInstance().create(MovieServices.class);
//        call1 = services.getTrailer(id1,key);
//        call1.enqueue(new Callback<TrailerResponse>() {
//            @Override
//            public void onResponse(Call<TrailerResponse> call1, Response<TrailerResponse> response) {
//                TrailerResponse trailerResponse = response.body();
//
//                if(trailerResponse!=null)
//                {
//                    trailers.clear();
//                    ArrayList<Trailer> mtrailer= trailerResponse.results;
//                    trailers.addAll(mtrailer);
//                    adapter1.notifyDataSetChanged();
//
//                }
//            }
//    });
    }


    public  void castTv(){

    }
}
