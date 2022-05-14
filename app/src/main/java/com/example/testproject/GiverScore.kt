package com.example.testproject

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class GiverScore : Fragment() {

    companion object {
        fun newInstance() = GiverScore()
    }

    private lateinit var viewModel: GiverScoreViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val nav = findNavController()
        val v2 = inflater.inflate(R.layout.giver_score_fragment, container, false)
        val button = v2.findViewById(R.id.button3) as Button
        val RateButton = v2.findViewById(R.id.button4) as Button
        val GiverScore: TextView = v2.findViewById(R.id.textView12)
        GiverScore.setText("Hey")

        button.setOnClickListener { view: View ->
            nav.navigate(R.id.profTemp)
        }
        RateButton.setOnClickListener { view: View ->
            GiverScore.setText("Hey")
        }
        return v2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GiverScoreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}