package com.example.sandbox.data.repositories

import com.example.sandbox.data.db.apis.CountriesApiRequest
import com.example.sandbox.data.db.entities.Country
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesRepository {
    suspend fun getCountries(): List<Country>? {
        val countries = Retrofit
            .Builder()
            .baseUrl("https://restcountries.eu/rest/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CountriesApiRequest::class.java)
        val result = countries
            .getCountries()
            .await()

        return result.body()
    }

}