package com.isurtionlsa.calculator.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.isurtionlsa.calculator.data.database.RequestHistoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CalculatorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRequestHistoryItem(requestHistoryItem: RequestHistoryItem)

    @Query("DELETE FROM calculator_history")
    fun deleteAllHistory()

    @Query("SELECT * FROM calculator_history")
    fun getRequestHistoryItems(): Flow<List<RequestHistoryItem>>
}