package com.example.sandbox.data.db.apis

import com.example.sandbox.data.db.entities.Movie
import com.example.sandbox.data.db.entities.MoviesPopularResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApiRequest {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") key: String): Deferred<Response<MoviesPopularResponse>>
}