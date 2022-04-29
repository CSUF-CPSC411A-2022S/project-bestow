package com.example.testproject.takeritem

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.data.TakerDataDao
import com.example.testproject.takerlist.TakerDataViewModel

/**
 * Generates an TakerDataViewModel tied to the database. It uses the provided taker ID to
 * to create the TakerItemViewModel.
 */
class TakerItemViewModelFactory(
    private val takerId: Long,
    private val dataSource: TakerDataDao, // Data access object
    private val application: Application
): ViewModelProvider.Factory {

    /**
     * Creates the TakerDataViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TakerItemViewModel::class.java)) { // ViewModel class
            return TakerItemViewModel(takerId, dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}