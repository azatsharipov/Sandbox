package com.example.sandbox.data.db.apis

import com.example.sandbox.data.db.entities.Country
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApiRequest {
    @GET("all?fields=name;flag")
    fun getCountries(): Deferred<Response<List<Country>>>
}