package com.example.goyal.showtime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerViewtop,recyclerViewpop,recyclerViewnowplay;
    MoviesAdapter adapter,adapter1,adapter2,adapter3;
    ArrayList<Movie> movies0 = new ArrayList<>();
    ArrayList<Movie> movies1 = new ArrayList<>();
    ArrayList<Movie> movies2 = new ArrayList<>();
    ArrayList<Movie> movies3 = new ArrayList<>();
    Toolbar toolbar;
    String key = "83a1822d264a2e25a286436acb2b1e12";
    Call<MovieResponse> call;
    ViewPager viewPager;
    int currentPage = 0;
    int NUM_PAGES = movies1.size();
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;
    public MainFragment() {
        // Required empty public constructor
    }


//    public static MainFragment newInstance(String param1, String param2) {
//        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = v.findViewById(R.id.pager);
        upComingNew();
//        recyclerViewupcom = v.findViewById(R.id.upcomrecyclerview);
//        upComing();
        recyclerViewnowplay = v.findViewById(R.id.nowplayrecyclerview);
        nowShowing();
        SnapHelper startSnapHelper = new SnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerViewnowplay);
        recyclerViewtop = v.findViewById(R.id.topraterecyclerview);
        topRated();
        SnapHelper startSnapHelper1 = new SnapHelper();
        startSnapHelper1.attachToRecyclerView(recyclerViewtop);
        recyclerViewpop = v.findViewById(R.id.poprecyclerview);
        popular();
        SnapHelper startSnapHelper2 = new SnapHelper();
        startSnapHelper2.attachToRecyclerView(recyclerViewpop);
        return v;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void popular() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewpop.setLayoutManager(layoutManager);
        adapter = new MoviesAdapter(getContext().getApplicationContext(), movies0);
        recyclerViewpop.setAdapter(adapter);
        MovieServices services = ApiClient.getInstance().create(MovieServices.class);
        call = services.getMovies("popular", key);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                if (movieResponse != null) {
                    movies0.clear();
                    ArrayList<Movie> popmovies = movieResponse.results;
                    movies0.addAll(popmovies);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Intent intent = new Intent(getActivity(), LoadFailActivity.class);
                startActivity(intent);

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void nowShowing(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewnowplay.setLayoutManager(layoutManager);
        adapter2 = new MoviesAdapter(getContext().getApplicationContext(),movies2);
        recyclerViewnowplay.setAdapter(adapter2);
        MovieServices services2 = ApiClient.getInstance().create(MovieServices.class);
        call = services2.getMovies("now_playing",key);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                if(movieResponse!=null)
                {
                    movies2.clear();
                    ArrayList<Movie> nowmovies= movieResponse.results;
                    movies2.addAll(nowmovies);
                    adapter2.notifyDataSetChanged();

                }
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Intent intent = new Intent(MainActivity.this,LoadFailActivity.class);
//                startActivity(intent);

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void topRated(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewtop.setLayoutManager(layoutManager);
        adapter3 = new MoviesAdapter(getContext().getApplicationContext(),movies3);
        recyclerViewtop.setAdapter(adapter3);
        MovieServices services3 = ApiClient.getInstance().create(MovieServices.class);
        call = services3.getMovies("top_rated",key);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                if(movieResponse!=null)
                {
                    movies3.clear();
                    ArrayList<Movie> topmovies= movieResponse.results;
                    movies3.addAll(topmovies);
                    adapter3.notifyDataSetChanged();

                }
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Intent intent = new Intent(MainActivity.this,LoadFailActivity.class);
//                startActivity(intent);

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void upComingNew() {
        final PagerAdapter adapterNew = new CustomAdapter(movies1, getContext().getApplicationContext());
        viewPager.setAdapter(adapterNew);
        MovieServices services1 = ApiClient.getInstance().create(MovieServices.class);
        call = services1.getMovies("upcoming", key);
        call.enqueue(new Callback<MovieResponse>()
        {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                if (movieResponse != null) {
                    movies1.clear();
                    ArrayList<Movie> upmovies = movieResponse.results;
                    movies1.addAll(upmovies);
                    adapterNew.notifyDataSetChanged();
                    final Handler handler = new Handler();
                    final Runnable Update = new Runnable() {
                        public void run() {
                            if (currentPage == NUM_PAGES - 1) {
                                currentPage = 0;
                            }
                            viewPager.setCurrentItem(currentPage++, true);
                        }
                    };

                    timer = new Timer(); // This will create a new Thread
                    timer.schedule(new TimerTask() { // task to be scheduled

                        @Override
                        public void run() {
                            handler.post(Update);
                        }
                    }, DELAY_MS, PERIOD_MS);
                }

            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Intent intent = new Intent(getActivity(),LoadFailActivity.class);
//                startActivity(intent);

            }
        });
        }


    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//}


