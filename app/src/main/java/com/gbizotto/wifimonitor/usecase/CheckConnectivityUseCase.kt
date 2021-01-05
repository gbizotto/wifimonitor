package com.gbizotto.wifimonitor.usecase

import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import com.gbizotto.wifimonitor.datasource.ConnectionLoggerDataSource
import javax.inject.Inject

interface CheckConnectivityUseCase {
    suspend operator fun invoke()
}

class CheckConnectivity @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val connectionLoggerDataSource: ConnectionLoggerDataSource
) : CheckConnectivityUseCase {
    override suspend fun invoke() {
        Log.v("CheckConnectivity", "injetou!")

        connectivityManager.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                Log.v("ConnectivityManager", "onAvailable")
                connectionLoggerDataSource.addLog(true)
            }

            override fun onLost(network: Network) {
                Log.v("ConnectivityManager", "onLost")
                connectionLoggerDataSource.addLog(false)
            }
        })
    }

}