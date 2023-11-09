package com.isurtionlsa.calculator.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calculator_history")
data class RequestHistoryItem(
    val result: String,
    @PrimaryKey val id: Int? = null
)
