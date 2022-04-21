package com.example.testproject

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.data.TakerDataDao

/**
 * Generates an TakerDataViewModel tied to the database.
 */
class TakerDataViewModelFactory(
    private val dataSource: TakerDataDao, // Data access object
    private val application: Application): ViewModelProvider.Factory {

    /**
     * Creates the TakerDataViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TakerDataViewModel::class.java)) { // ViewModel class
            return TakerDataViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}