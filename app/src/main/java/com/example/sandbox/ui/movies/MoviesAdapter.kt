package com.example.sandbox.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sandbox.R
import com.example.sandbox.data.db.entities.Movie
import com.squareup.picasso.Picasso

class MoviesAdapter(var movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tv_movie_item_name)
        var tvDate: TextView = view.findViewById(R.id.tv_movie_item_date)
        var ivMovie: ImageView = view.findViewById(R.id.iv_movie_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false) as View
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.tvName.setText(movies[position].name)
        holder.tvDate.setText(movies[position].date)
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2${movies[position].posterPath}")
            .into(holder.ivMovie)
    }
}