package com.example.testproject.takerlist

import android.app.Application
import androidx.lifecycle.*
import com.example.testproject.data.TakerData
import com.example.testproject.data.TakerDataDao
import kotlinx.coroutines.launch

/**
 * TakerDataViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values.
 */
class TakerDataViewModel(
    val database: TakerDataDao, // Data access object for the Intersection entity
    application: Application
) : AndroidViewModel(application) {

    var takername = MutableLiveData("")
    var item = MutableLiveData("")
    var description = MutableLiveData("")

    // Retrieves all Intersection objects from the database
    // Represented as a LiveData<List<Intersection>>
    val takerList = database.getAllIntersections()

    /**
     * Creates a LiveData<String> that contains information from all TakerData objects.
     * The Transformations.map function takes a LiveData object, performs operations on the
     * object and returns a LiveData-wrapped object.
     */
    var takerString = Transformations.map(takerList) {
            takers -> // intersections refer to the underlying data List<Intersection>
        var result = ""
        // Retrieve each Intersection object from the list
        for (taker in takers) {
            // Create a string using the Intersection name and location.
            // The intersection string is appended to a longer string with all intersections.
            result += "${taker.takername} @ ${taker.item} @ ${taker.description}\n"
        }
        // Returns the aggregated String that is wrapped by the map function in a LiveData object.
        result
    }

    /**
     * Inserts the TakerData object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Intersection object using data stored in the EditText views
            var taker = TakerData()
            taker.takername = takername.value.toString()
            taker.item = item.value.toString()
            taker.description = description.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(taker)
        }

    }

    /**
     * Deletes all Intersection entities in the database.
     */
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}