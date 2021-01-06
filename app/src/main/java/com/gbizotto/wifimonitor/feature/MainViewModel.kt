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

    fun onAction(action: Action) {
        when (action) {
            Action.START -> onStart()
            Action.REFRESH -> refresh()
        }
    }

    private fun onStart() {
            checkConnectivity()
    }

    private fun refresh() {
        viewModelScope.launch {
            logs.postValue(getAllLogs())
        }
    }
}

enum class Action {
    START,
    REFRESH
}