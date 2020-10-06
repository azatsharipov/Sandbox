package com.example.sandbox.ui.covid

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

import com.example.sandbox.R
import com.example.sandbox.data.db.entities.CovidItem
import com.example.sandbox.data.db.entities.CovidSummary

class CovidFragment : Fragment() {

    private lateinit var viewModel: CovidViewModel
    private lateinit var pb: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var covidAdapter: CovidAdapter
    private var covidItems = ArrayList<CovidItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.covid_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(CovidViewModel::class.java)
        viewModel.covidCountriesLiveData.observe(this, Observer {
            updateCovidItems(it)
        })

        pb = view.findViewById(R.id.pb_covid)
        recyclerView = view.findViewById(R.id.rv_covid)
        showList()
        startLoading()

        return view
    }

    fun startLoading() {
        pb.visibility = View.VISIBLE
        viewModel.loadCovidData()
    }

    fun stopLoading() {
        pb.visibility = View.GONE
    }

    fun updateCovidItems(summary: CovidSummary) {
        covidItems.clear()
        summary.global.country = "All"
        covidItems.add(summary.global)
        summary.covidItems.forEach {
            covidItems.add(it)
        }
        covidAdapter.notifyDataSetChanged()
        stopLoading()
    }

    fun showList() {
        covidAdapter = CovidAdapter(covidItems)
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = covidAdapter
        }
    }
}
