package com.gbizotto.wifimonitor.usecase

import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.datasource.ConnectionLoggerDataSource
import javax.inject.Inject

interface GetAllLogsUseCase {
    suspend operator fun invoke(): List<ConnectionLog>
}

class GetAllLogs @Inject constructor(
    private val connectionLoggerDataSource: ConnectionLoggerDataSource,
) : GetAllLogsUseCase {
    override suspend fun invoke(): List<ConnectionLog> = connectionLoggerDataSource.getAllLogs()
}