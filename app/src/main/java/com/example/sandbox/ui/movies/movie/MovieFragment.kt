package com.example.sandbox.ui.movies.movie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.app.progresviews.ProgressWheel

import com.example.sandbox.R
import com.example.sandbox.data.db.entities.Movie
import com.squareup.picasso.Picasso

class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var tvName: TextView
    private lateinit var tvOverview: TextView
    private lateinit var ivMovie: ImageView
    private lateinit var wheelprogress: ProgressWheel
    private var movie: Movie? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movie_fragment, container, false)

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        tvName = view.findViewById(R.id.tv_movie_name)
        tvOverview = view.findViewById(R.id.tv_movie_overview)
        ivMovie = view.findViewById(R.id.iv_movie)
        wheelprogress = view.findViewById(R.id.wheelprogress_movie)

        movie = arguments?.getParcelable("movie")
        tvName.setText(movie?.name)
        tvOverview.setText(movie?.overview)
        (movie?.rating?.times(36))?.toInt()?.let { wheelprogress.setPercentage(it) }
        wheelprogress.setStepCountText(movie?.rating.toString())
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2${movie?.posterPath}")
            .into(ivMovie)

        return view
    }

}
