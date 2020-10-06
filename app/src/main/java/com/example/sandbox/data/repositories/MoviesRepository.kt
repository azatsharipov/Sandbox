package com.example.sandbox.data.repositories

import com.example.sandbox.BuildConfig
import com.example.sandbox.data.db.apis.TmdbApiRequest
import com.example.sandbox.data.db.entities.Movie
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepository() {
    var tmdbApiKey = BuildConfig.TMDB_API_KEY

    suspend fun getMovies(): List<Movie>? {
        val movies = Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(TmdbApiRequest::class.java)
        val result = movies
            .getMovies(tmdbApiKey)
            .await()
        return result.body()?.results
    }
}