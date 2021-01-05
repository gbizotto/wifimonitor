package com.gbizotto.wifimonitor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logs")
data class ConnectionLog(
    val connected: Boolean,
    val timestamp: Long,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}