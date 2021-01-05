package com.gbizotto.wifimonitor.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log

class CheckConnectivity : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isConnected = intent?.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)

        Log.v("CheckConnectivity", "intent?.action = ${intent?.action}, isConnected = $isConnected")
    }
}