package com.hp.moviesapp_accubits.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.harishpadmanabh.apppreferences.AppPreferences;
import com.hp.moviesapp_accubits.ConstantsKt;
import com.hp.moviesapp_accubits.R;
import com.hp.moviesapp_accubits.data.model.MoviesResponse;

public class NewMoviesAdapter extends RecyclerView.Adapter<NewMoviesAdapter.NewMoviesViewHolder> {

    Context context;
    MoviesResponse moviesResponse;
    private AppPreferences appPreferences;


    public NewMoviesAdapter(Context context, MoviesResponse moviesResponse) {
        this.context = context;
        this.moviesResponse = moviesResponse;
    }

    public NewMoviesAdapter(MoviesResponse moviesResponse) {
        this.moviesResponse = moviesResponse;
    }

    @NonNull
    @Override
    public NewMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        if (context != null)
            appPreferences = AppPreferences.getInstance(context, context.getResources().getString(R.string.app_name));

        return new NewMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewMoviesViewHolder holder, int position) {

        if (moviesResponse.getResults().get(position).getPosterPath() != null &&
                moviesResponse.getResults().get(position).getOriginalTitle() != null
        ) {
            Glide.with(holder.movieImg.getContext())

                    .load(ConstantsKt.POSTER_BASE_URL + moviesResponse.getResults().get(position).getPosterPath())
                    .into(holder.movieImg)
            ;

            holder.movieName.setText(moviesResponse.getResults().get(position).getOriginalTitle());
        }

    }

    @Override
    public int getItemCount() {
        return moviesResponse.getResults().size();
    }

    class NewMoviesViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView movieImg;
        AppCompatTextView movieName;

        public NewMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImg = itemView.findViewById(R.id.movie_img);
            movieName = itemView.findViewById(R.id.movie_name);
        }
    }

}
