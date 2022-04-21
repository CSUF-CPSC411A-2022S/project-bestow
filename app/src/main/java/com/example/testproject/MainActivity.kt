package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.data.TakerDatabase
import com.example.testproject.databinding.ActivityMainBinding

/**
 * Main interface of the application
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create data binding
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Get reference to this application
        val application = requireNotNull(this).application

        // Retrieve Taker data access object.
        val dataSource = TakerDatabase.getInstance(application).takerDao

        // Create a factory that generates TakerViewModels connected to the database.
        val viewModelFactory = TakerDataViewModelFactory(dataSource, application)

        // Generate an TakerViewModel using the factory.
        val takerViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(TakerDataViewModel::class.java)

        // Connect the TakerViewModel with the variable in the layout
        binding.takerdataViewModel = takerViewModel

        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this
    }
}