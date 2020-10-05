package com.example.sandbox.data.db.entities

import com.google.gson.annotations.SerializedName

data class CovidSummary (
    @SerializedName("Global")
    var global: CovidItem,

    @SerializedName("Countries")
    var covidItems: List<CovidItem>
)