package com.example.sandbox.data.apis

import com.example.sandbox.data.db.entities.CovidItem
import com.example.sandbox.data.db.entities.CovidSummary
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CovidApiRequest {

    @GET("summary")
    fun getSummary(): Deferred<Response<CovidSummary>>

    @GET("countries")
    fun getCountries(): Deferred<Response<List<CovidItem>>>

}