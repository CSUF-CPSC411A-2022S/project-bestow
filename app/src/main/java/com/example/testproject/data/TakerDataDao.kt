package com.example.testproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Data access object for the Taker entity. The class describes how data is
 * stored, updated, retrieved, or deleted from the database.
 */
@Dao
interface TakerDataDao {
    // Add an taker entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(takerData: TakerData)

    // Update an taker entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(takerData: TakerData)

    // Custom query for retrieving a single Taker from a table in the database using
    // its intersection id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from taker_table WHERE takerId = :key")
    fun get(key: Long): LiveData<TakerData>?

    // Custom query for retrieving all Taker entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from taker_table ORDER BY takerId DESC")
    fun getAllIntersections(): LiveData<List<TakerData>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from taker_table")
    suspend fun clear()
}