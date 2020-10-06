package com.example.sandbox.ui.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.sandbox.R
import com.example.sandbox.data.db.entities.Movie

class MoviesFragment : Fragment() {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var pb: ProgressBar
    private var movies = ArrayList<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movies_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        viewModel.moviesLiveData.observe(this, Observer {
            updateMovies(it)
        })

        pb = view.findViewById(R.id.pb_movies)
        recyclerView = view.findViewById(R.id.rv_movies)
        showList()
        startLoading()

        return view
    }

    fun startLoading() {
        pb.visibility = View.VISIBLE
        viewModel.loadMovies()
    }

    fun updateMovies(items: List<Movie>) {
        movies.clear()
        items.forEach {
            movies.add(it)
        }
        moviesAdapter.notifyDataSetChanged()
        pb.visibility = View.GONE
    }

    fun showList() {
        moviesAdapter = MoviesAdapter(movies)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3)
            adapter = moviesAdapter
        }
    }

}
