package com.example.testproject.takeritem

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.R
import com.example.testproject.data.TakerDatabase
import com.example.testproject.databinding.TakerItemFragmentBinding
import com.example.testproject.takerlist.TakerDataViewModel
import com.example.testproject.takerlist.TakerDataViewModelFactory
import com.example.testproject.takerlist.TakerItemFragmentArgs

/**
 * Fragment that displays a single intersection.
 */
class TakerItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve arguments passed from the RecyclerView
        val args = TakerItemFragmentArgs.fromBundle(
            requireArguments()
        )

        // Create data binding
        val binding: TakerItemFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.taker_item_fragment, container, false)

        // Get reference to this application
        val application = requireNotNull(this.activity).application

        // Retrieve Intersection data access object.
        val dataSource = TakerDatabase.getInstance(application).takerDao

        // Create a factory that generates an IntersectionViewModel connected to the database. The
        // takerId passed from the RecyclerView is used to display the corresponding
        // information.
        val viewModelFactory =
            TakerItemViewModelFactory(args.takerId, dataSource, application)

        // Generate an TakerItemViewModel using the factory.
        val takerItemViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(TakerItemViewModel::class.java)

        // Connect the TakerItemViewModel with the variable in the layout
        binding.takerItemViewModel = takerItemViewModel

        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        return binding.root
    }
}