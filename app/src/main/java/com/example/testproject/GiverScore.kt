package com.example.testproject

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
//Most of the activity that happens is in this code. Firstly, the declarations find the components they relate to. "ScoreGiver"
//was suppose to give access to the class couldn't implement it in time. "button" navigates to the other fragment. "RateButton"
//suppose to give the score, but doesn't work with the intended purpose. It just change the string of the giver score.
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
        var GiverScore: TextView = v2.findViewById(R.id.textView5)
        var UserRating: EditText = v2.findViewById(R.id.textView10)
        var ScoreGiver: GivingScore

        button.setOnClickListener { view: View ->
            nav.navigate(R.id.profTemp)
        }
        RateButton.setOnClickListener { view: View ->
            var string: String =  UserRating.getText().toString()

            GiverScore.setText(string)
            
        }
        return v2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GiverScoreViewModel::class.java)
    }

}