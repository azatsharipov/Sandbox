package com.example.sandbox.ui.covid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sandbox.data.db.entities.CovidItem
import com.example.sandbox.data.db.entities.CovidSummary
import com.example.sandbox.data.repositories.CountriesRepository
import com.example.sandbox.data.repositories.CovidRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CovidViewModel : ViewModel() {
    val covidCountriesLiveData = MutableLiveData<CovidSummary>()

    fun loadCovidData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val covidSummary = CovidRepository().getSummary()
                covidCountriesLiveData.postValue(covidSummary)
            }
        }

    }
}
