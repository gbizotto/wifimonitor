package com.gbizotto.wifimonitor.feature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.datasource.ConnectionLoggerDataSource
import com.gbizotto.wifimonitor.usecase.CheckConnectivityUseCase

class MainViewModel @ViewModelInject constructor(
    private val checkConnectivity: CheckConnectivityUseCase,
    private val connectionLoggerDataSource: ConnectionLoggerDataSource,
) : ViewModel() {

    val logs = MutableLiveData<List<ConnectionLog>>()

    fun onStart() {
        checkConnectivity()
    }

    fun refresh() {
        connectionLoggerDataSource.getAllLogs {
            logs.value = it
        }
    }
}