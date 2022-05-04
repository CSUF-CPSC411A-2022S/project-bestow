package com.example.testproject.takerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testproject.R
import com.example.testproject.data.TakerDatabase
import com.example.testproject.databinding.TakerListFragmentBinding

/**
 * Fragment that displays the input text fields and intersection list
 */
class TakerListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create data binding
        val binding: TakerListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.taker_list_fragment, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Taker data access object.
        val dataSource = TakerDatabase.getInstance(application).takerDao

        // Create a factory that generates TakerDataViewModels connected to the database.
        val viewModelFactory = TakerDataViewModelFactory(dataSource, application)

        // Generate an TakerDataViewModel using the factory.
        val takerdataViewModel=
            ViewModelProvider(
                this, viewModelFactory).get(TakerDataViewModel::class.java)

        // Connect the TakerDataViewModel with the variable in the layout
        binding.takerdataViewModel = takerdataViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        // Provide a lambda function that is called when the RecyclerView item is selected.
        var takerAdapter = TakerListAdapter(TakerListener {
                takerId ->
            // Navigate to the taker view and provide the id of the taker referenced
            // by the select RecyclerView item.
            this.findNavController().navigate(
               TakerListFragmentDirections
                    .actionTakerListFragmentToTakerItemFragment(takerId)
            )
        })
        // Attach intersection adapter.
        binding.takerRecyclerview.adapter = takerAdapter

        // Submit an updated list to the intersection listAdapter whenever it changes. Take note
        // intersectionList is a LiveData object.
        takerdataViewModel.takerList.observe(viewLifecycleOwner, Observer {
            it?.let {
                takerAdapter.submitList(it)
            }
        })
        return binding.root
    }
}