package com.gbizotto.wifimonitor.datasource

import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.data.ConnectionLogDao
import javax.inject.Inject
import javax.inject.Singleton

interface ConnectionLoggerDataSource {
    suspend fun addLog(connected: Boolean)
    suspend fun getAllLogs(): List<ConnectionLog>
    fun removeLogs()
}

@Singleton
class ConnectionLoggerLocalDataSource @Inject constructor(
    private val logDao: ConnectionLogDao
) : ConnectionLoggerDataSource {

    override suspend fun addLog(connected: Boolean) {
        logDao.insertAll(
            ConnectionLog(connected, System.currentTimeMillis())
        )
    }

    override suspend fun getAllLogs(): List<ConnectionLog> = logDao.getAll()

    override fun removeLogs() {
        TODO("Not yet implemented")
    }
}