package com.gbizotto.wifimonitor.di

import com.gbizotto.wifimonitor.usecase.CheckConnectivity
import com.gbizotto.wifimonitor.usecase.CheckConnectivityUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bind(useCase: CheckConnectivity) : CheckConnectivityUseCase
}