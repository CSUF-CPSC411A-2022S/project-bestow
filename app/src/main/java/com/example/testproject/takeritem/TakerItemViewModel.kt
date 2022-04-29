package com.example.testproject.takeritem

import android.app.Application
import androidx.lifecycle.*
import com.example.testproject.data.TakerData
import com.example.testproject.data.TakerDataDao
import kotlinx.coroutines.launch

/**
 * TakerViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values. It retrieves the corresponding takerdata
 * with the provided intersection ID.
 */
class TakerItemViewModel(
    val takerId: Long,
    val database: TakerDataDao, // Data access object for the TakerData entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped takern object given its ID
    val taker = database.get(takerId)
}