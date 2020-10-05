package com.example.sandbox.data.db.entities

import com.google.gson.annotations.SerializedName

data class CovidItem (
    @SerializedName("Country")
    var country: String,

    @SerializedName("NewConfirmed")
    var newConfirmed: Int = -1,

    @SerializedName("TotalConfirmed")
    var totalConfirmed: Int = -1,

    @SerializedName("NewDeaths")
    var newDeaths: Int = -1,

    @SerializedName("TotalDeaths")
    var totalDeaths: Int = -1,

    @SerializedName("NewRecovered")
    var newRecovered: Int = -1,

    @SerializedName("TotalRecovered")
    var totalRecovered: Int = -1,

    @SerializedName("Slug")
    var slug: String? = null,

    @SerializedName("CountryCode")
    var countryCode: String? = null,

    @SerializedName("ISO2")
    var iso2: String? = null
)