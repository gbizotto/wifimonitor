package com.gbizotto.wifimonitor.usecase

import android.net.ConnectivityManager
import android.net.Network
import com.gbizotto.wifimonitor.datasource.ConnectionLoggerDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

interface CheckConnectivityUseCase {
    operator fun invoke()
}

class CheckConnectivity @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val connectionLoggerDataSource: ConnectionLoggerDataSource
) : CheckConnectivityUseCase {
    override fun invoke() {
        connectivityManager.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                GlobalScope.launch {
                    connectionLoggerDataSource.addLog(true)
                }
            }

            override fun onLost(network: Network) {
                GlobalScope.launch {
                    connectionLoggerDataSource.addLog(false)
                }
            }
        })
    }
}