package com.hp.moviesapp_accubits.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hp.moviesapp_accubits.ConstantsKt;
import com.hp.moviesapp_accubits.R;
import com.hp.moviesapp_accubits.data.model.MoviesResponse;

public class NewVideosAdapter extends RecyclerView.Adapter<NewVideosAdapter.NewVideosViewHolder> {

    MoviesResponse moviesResponse;

    public NewVideosAdapter(MoviesResponse moviesResponse) {
        this.moviesResponse = moviesResponse;
    }

    @NonNull
    @Override
    public NewVideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newvideos, parent, false);
        return new NewVideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewVideosViewHolder holder, int position) {

        if(moviesResponse.getResults().get(position).getBackdropPath() != null) {
            Glide.with(holder.movieImg.getContext())
                    .load(ConstantsKt.BACKDROP_URL + moviesResponse.getResults().get(position).getBackdropPath())
                    .into(holder.movieImg);
            holder.movieName.setText(moviesResponse.getResults().get(position).getTitle());
        }


    }

    @Override
    public int getItemCount() {
        return moviesResponse.getResults().size();
    }

    class NewVideosViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView movieImg;
        AppCompatTextView movieName;



        public NewVideosViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImg = itemView.findViewById(R.id.movie_img);
            movieName = itemView.findViewById(R.id.movie_name);
        }
    }
}
