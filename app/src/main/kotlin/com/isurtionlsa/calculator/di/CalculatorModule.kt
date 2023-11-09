package com.isurtionlsa.calculator.di

import android.content.Context
import androidx.room.Room
import com.isurtionlsa.calculator.data.database.CalculatorDao
import com.isurtionlsa.calculator.data.database.CalculatorDatabase
import com.isurtionlsa.calculator.data.repository.RequestHistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CalculatorModule {

    @Provides
    @Singleton
    fun provideCalculatorDatabase(
        @ApplicationContext context: Context,
    ): CalculatorDatabase {
        return Room.databaseBuilder(
            context,
            CalculatorDatabase::class.java,
            "calculator_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideRequestHistoryRepository(database: CalculatorDatabase): RequestHistoryRepository {
        return RequestHistoryRepository.Core(database.dao)
    }
}