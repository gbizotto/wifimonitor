package com.gbizotto.wifimonitor.feature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.usecase.CheckConnectivityUseCase
import com.gbizotto.wifimonitor.usecase.GetAllLogsUseCase
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val checkConnectivity: CheckConnectivityUseCase,
    private val getAllLogs: GetAllLogsUseCase,
) : ViewModel() {

    val logs = MutableLiveData<List<ConnectionLog>>()

    fun onStart() {
        viewModelScope.launch {
            checkConnectivity()
        }
    }

    fun refresh() {
        viewModelScope.launch {
            logs.postValue(getAllLogs())
        }
    }
}