package com.example.testproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.R
import android.widget.Button
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.testproject.databinding.ActivityMainBinding

class ProfTemp : Fragment() {

    companion object {
        fun newInstance() = ProfTemp()
    }

    private lateinit var viewModel: ProfTempViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val nav = findNavController()
        val v1 = inflater.inflate(R.layout.prof_temp_fragment, container, false)
        val button = v1.findViewById(R.id.button2) as Button

        button.setOnClickListener { view: View ->
        nav.navigate(R.id.giverScore)
        }
     //   v1.textView2.setOnClickListener { Navigation.findNavController(v1).navigate(R.id.action_profTemp_to_giverScore) }
        return v1
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfTempViewModel::class.java)
        // TODO: Use the ViewModel
    }

}