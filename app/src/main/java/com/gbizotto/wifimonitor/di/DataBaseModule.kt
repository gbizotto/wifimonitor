package com.gbizotto.wifimonitor.di

import android.content.Context
import androidx.room.Room
import com.gbizotto.wifimonitor.data.AppDatabase
import com.gbizotto.wifimonitor.data.ConnectionLogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataBaseModule {

    @Provides
    fun provideLogDao(database: AppDatabase): ConnectionLogDao {
        return database.connectionLogDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "logging.db"
        ).build()
    }
}