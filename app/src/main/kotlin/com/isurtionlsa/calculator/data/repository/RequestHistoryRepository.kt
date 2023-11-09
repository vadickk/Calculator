package com.isurtionlsa.calculator.data.repository

import com.isurtionlsa.calculator.data.database.CalculatorDao
import com.isurtionlsa.calculator.data.database.RequestHistoryItem
import kotlinx.coroutines.flow.Flow

interface RequestHistoryRepository {

    suspend fun addRequestHistoryItem(requestHistoryItem: RequestHistoryItem)

    suspend fun deleteAllHistory()

    fun getRequestHistoryItems(): Flow<List<RequestHistoryItem>>

    class Core(private val dao: CalculatorDao) : RequestHistoryRepository {
        override suspend fun addRequestHistoryItem(requestHistoryItem: RequestHistoryItem) {
            dao.insertRequestHistoryItem(requestHistoryItem)
        }

        override suspend fun deleteAllHistory() {
            dao.deleteAllHistory()
        }

        override fun getRequestHistoryItems(): Flow<List<RequestHistoryItem>> {
            return dao.getRequestHistoryItems()
        }
    }
}