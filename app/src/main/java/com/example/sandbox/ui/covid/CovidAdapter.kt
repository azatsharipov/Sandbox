package com.example.sandbox.ui.covid

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sandbox.R
import com.example.sandbox.data.db.entities.CovidItem
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso

class CovidAdapter (var covidItems: List<CovidItem>) :
    RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

        class CovidViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
            var tvCountry: TextView = view.findViewById(R.id.tv_covid_item_country)
            var tvConfirmed: TextView = view.findViewById(R.id.tv_covid_item_confirmed)
            var tvDeaths: TextView = view.findViewById(R.id.tv_covid_item_deaths)
            var tvRecovered: TextView = view.findViewById(R.id.tv_covid_item_recovered)
            var ivCountry: ImageView = view.findViewById(R.id.iv_covid_item_country)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.covid_item, parent, false) as View
            return CovidViewHolder(view)
        }

        override fun getItemCount(): Int {
            return covidItems.size
        }

        override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
            holder.tvCountry.setText(covidItems[position].country)
            holder.tvConfirmed.setText(covidItems[position].totalConfirmed.toString())
            holder.tvDeaths.setText(covidItems[position].totalDeaths.toString())
            holder.tvRecovered.setText(covidItems[position].totalRecovered.toString())
            Picasso.get().load("http://www.geognos.com/api/en/countries/flag/${covidItems[position].countryCode}.png").into(holder.ivCountry)
//            GlideApp.with(holder.view).load(covidItems[position].flag).into(holder.ivCountry)
//            GlideToVectorYou.justLoadImage(holder.view.context as Activity,
//                Uri.parse(covidItems[position].flag), holder.ivCountry)

//            Glide.with(holder.view).load("http://goo.gl/gEgYUd").into(holder.ivCountry);
        }

    }