package com.gbizotto.wifimonitor.di

import com.gbizotto.wifimonitor.datasource.ConnectionLoggerDataSource
import com.gbizotto.wifimonitor.datasource.ConnectionLoggerLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bind(dataSource: ConnectionLoggerLocalDataSource): ConnectionLoggerDataSource
}