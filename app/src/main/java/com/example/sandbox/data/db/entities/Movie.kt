package com.example.sandbox.data.db.entities

import com.google.gson.annotations.SerializedName

data class Movie (
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val date: String?,
    val overview: String?
)

data class MoviesPopularResponse (
    val results: List<Movie>
)