package com.gbizotto.wifimonitor.usecase

import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.datasource.ConnectionLoggerDataSource
import javax.inject.Inject

interface GetAllLogsUseCase {
    operator fun invoke(): List<ConnectionLog>
}

class GetAllLogs @Inject constructor(
    private val connectionLoggerDataSource: ConnectionLoggerDataSource,
) : GetAllLogsUseCase {
    override fun invoke(): List<ConnectionLog> {
        TODO()
//        var list: List<ConnectionLog>
//        connectionLoggerDataSource.getAllLogs {
//            list = it
//        }
//        return list
    }
}