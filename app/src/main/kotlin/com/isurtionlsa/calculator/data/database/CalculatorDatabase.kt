package com.isurtionlsa.calculator.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RequestHistoryItem::class], version = 1)
abstract class CalculatorDatabase: RoomDatabase() {

    abstract val dao: CalculatorDao
}