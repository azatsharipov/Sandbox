package com.example.sandbox.ui.hello

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

import com.example.sandbox.R
import kotlinx.android.synthetic.main.activity_main.*

class HelloFragment : Fragment() {

    lateinit var btTodo: Button
    lateinit var btCovid: Button
    lateinit var btMovies: Button

    private lateinit var viewModel: HelloViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.hello_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HelloViewModel::class.java)
        btTodo = view.findViewById(R.id.bt_hello_todo)
        btCovid = view.findViewById(R.id.bt_hello_covid)
        btMovies = view.findViewById(R.id.bt_hello_movies)
        btTodo.setOnClickListener {
            findNavController().navigate(R.id.action_helloFragment_to_todoFragment)
        }
        btCovid.setOnClickListener {
            findNavController().navigate(R.id.action_helloFragment_to_covidFragment)
        }
        btMovies.setOnClickListener {
            findNavController().navigate(R.id.action_helloFragment_to_moviesFragment)
        }
        return view
    }

}
