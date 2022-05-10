package com.example.testproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

class GiverScore : Fragment() {

    companion object {
        fun newInstance() = GiverScore()
    }

    private lateinit var viewModel: GiverScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
   //     val v2 = inflater.inflate(R.layout.giver_score_fragment, container, false)
  //      v2.textView.setOnClickListener { Navigation.findNavController(v1).navigate(R.id.action_giverScore_to_profTemp) }
        return inflater.inflate(R.layout.giver_score_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GiverScoreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}