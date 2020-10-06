package com.example.sandbox.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sandbox.data.db.entities.Movie
import com.example.sandbox.data.repositories.MoviesRepository
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    val moviesLiveData = MutableLiveData<List<Movie>>()

    fun loadMovies() {
        viewModelScope.launch {
            val movies = MoviesRepository().getMovies()
            moviesLiveData.postValue(movies)
        }
    }
}
