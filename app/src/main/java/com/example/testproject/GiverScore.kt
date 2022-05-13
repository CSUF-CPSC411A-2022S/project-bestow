package com.example.testproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class GiverScore : Fragment() {

    companion object {
        fun newInstance() = GiverScore()
    }

    private lateinit var viewModel: GiverScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val nav = findNavController()
        val v2 = inflater.inflate(R.layout.giver_score_fragment, container, false)
        val button = v2.findViewById(R.id.button3) as Button

        button.setOnClickListener { view: View ->
            nav.navigate(R.id.profTemp)
        }
        //   v1.textView2.setOnClickListener { Navigation.findNavController(v1).navigate(R.id.action_profTemp_to_giverScore) }
        return v2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GiverScoreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}