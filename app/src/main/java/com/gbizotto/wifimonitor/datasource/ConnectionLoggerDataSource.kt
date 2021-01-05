package com.gbizotto.wifimonitor.datasource

import android.os.Handler
import android.os.Looper
import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.data.ConnectionLogDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

interface ConnectionLoggerDataSource {
    suspend fun addLog(connected: Boolean)
    suspend fun getAllLogs(callback: (List<ConnectionLog>) -> Unit)
    fun removeLogs()
}

@Singleton
class ConnectionLoggerLocalDataSource @Inject constructor(
    private val logDao: ConnectionLogDao
) : ConnectionLoggerDataSource {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    override suspend fun addLog(connected: Boolean) {
//        executorService.execute {
            logDao.insertAll(
                ConnectionLog(connected, System.currentTimeMillis())
            )
//        }
    }

    override suspend fun getAllLogs(callback: (List<ConnectionLog>) -> Unit) {
        executorService.execute {
            val logs = logDao.getAll()
            mainThreadHandler.post { callback(logs) }
        }
    }

    override fun removeLogs() {
        TODO("Not yet implemented")
    }

}