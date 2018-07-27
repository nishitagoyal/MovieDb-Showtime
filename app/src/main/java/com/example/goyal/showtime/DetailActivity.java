package com.example.goyal.showtime;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    int id1;
    ArrayList<Cast> casts = new ArrayList<>();
    ArrayList<Trailer> trailers = new ArrayList<>();
    TextView textView,textView1,textView2,textView3,textView4;
    ImageView imageView,imageView1;
    RecyclerView recyclerViewcast,recyclerViewtrailer;
    Call<MovieResponse> call;
    Call<TrailerResponse> call1;
    DetailAdapter adapter;
    Button plus, minus;
    TrailerAdapter adapter1;
    String key = "83a1822d264a2e25a286436acb2b1e12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent1 = getIntent();
        if((getIntent().hasExtra("id")) && (getIntent().hasExtra("poster"))&& (getIntent().hasExtra("title"))&&(getIntent().hasExtra("overview"))){
            id1 = intent1.getIntExtra("id",0);
            String poster =intent1.getStringExtra("poster");
            String title =intent1.getStringExtra("title");
            String overview =intent1.getStringExtra("overview");
            String language = intent1.getStringExtra("language");
            String releasedate = intent1.getStringExtra("releasedate");
            String adult = intent1.getStringExtra("adult");
            String backdrop =intent1.getStringExtra("backdrop");

            textView = findViewById(R.id.title);
            textView1 = findViewById(R.id.overview);
            imageView = findViewById(R.id.poster);
            textView2 = findViewById(R.id.language);
            textView3 = findViewById(R.id.releasedate);
            textView4 = findViewById(R.id.adult);
            imageView1 = findViewById(R.id.backdrop);
            textView.setText(title);
            textView1.setText("Overview: " + overview);
            textView2.setText("Language: " + language);
            textView3.setText("Released On: " + releasedate);
            if(adult==null)
            {
                textView4.setText("Grade:" + "'A'");
            }
            else
            {
                textView4.setText("Grade: " + "'NA'");
            }
            plus = (Button) findViewById(R.id.plus);
            minus = (Button) findViewById(R.id.minus);
            plus.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    plus.setVisibility(View.GONE);
                    minus.setVisibility(View.VISIBLE);
                    textView1.setMaxLines(Integer.MAX_VALUE);

                }
            });

            minus.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    minus.setVisibility(View.GONE);
                    plus.setVisibility(View.VISIBLE);
                    textView1.setMaxLines(3);

                }
            });


            new Picasso.Builder(DetailActivity.this)
                    .listener(new Picasso.Listener() {
                        @Override
                        public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                            Log.d("lalala",exception.getMessage());
                        }
                    }).build()
                    .load(poster)
                    .into(imageView);
            new Picasso.Builder(DetailActivity.this)
                    .listener(new Picasso.Listener() {
                        @Override
                        public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                            Log.d("lalala",exception.getMessage());
                        }
                    }).build()
                    .load(backdrop)
                    .into(imageView1);
        }


        recyclerViewcast=findViewById(R.id.cast);
        cast();
        SnapHelper startSnapHelper3= new SnapHelper();
        startSnapHelper3.attachToRecyclerView(recyclerViewcast);
        recyclerViewtrailer=findViewById(R.id.video);
        video();
        SnapHelper startSnapHelper4 = new SnapHelper();
        startSnapHelper4.attachToRecyclerView(recyclerViewtrailer);

    }
    public void cast(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewcast.setLayoutManager(layoutManager);
        adapter = new DetailAdapter(casts,getApplicationContext());
        recyclerViewcast.setAdapter(adapter);
        MovieServices services = ApiClient.getInstancecast().create(MovieServices.class);
        call = services.getDetails(id1,key);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();

                if(movieResponse!=null)
                {
                    casts.clear();
                    ArrayList<Cast> tcasts= movieResponse.cast;
                    casts.addAll(tcasts);
                    adapter.notifyDataSetChanged();

                }
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
    public void video(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewtrailer.setLayoutManager(layoutManager);
        adapter1 = new TrailerAdapter(getApplicationContext(),trailers);
        recyclerViewtrailer.setAdapter(adapter1);
        MovieServices services = ApiClient.getInstance().create(MovieServices.class);
        call1 = services.getTrailer(id1,key);
        call1.enqueue(new Callback<TrailerResponse>() {
            @Override
            public void onResponse(Call<TrailerResponse> call1, Response<TrailerResponse> response) {
                TrailerResponse trailerResponse = response.body();

                if(trailerResponse!=null)
                {
                    trailers.clear();
                    ArrayList<Trailer> mtrailer= trailerResponse.results;
                    trailers.addAll(mtrailer);
                    adapter1.notifyDataSetChanged();

                }
            }
            @Override
            public void onFailure(Call<TrailerResponse> call1, Throwable t) {

            }
        });

    }

}
