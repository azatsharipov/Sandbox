package com.example.sandbox.data.repositories

import com.example.sandbox.data.db.apis.CovidApiRequest
import com.example.sandbox.data.db.entities.CovidItem
import com.example.sandbox.data.db.entities.CovidSummary
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CovidRepository() {

    suspend fun getCountries(): List<CovidItem>? {
        val covidCountries = Retrofit
            .Builder()
            .baseUrl("https://api.covid19api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CovidApiRequest::class.java)
        val result = covidCountries
            .getCountries()
            .await()

        return result.body()
    }

    suspend fun getSummary(): CovidSummary? {
        val covidItems = Retrofit
            .Builder()
            .baseUrl("https://api.covid19api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CovidApiRequest::class.java)
        val result = covidItems
            .getSummary()
            .await()

        return result.body()
    }

}