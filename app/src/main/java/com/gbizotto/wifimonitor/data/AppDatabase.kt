package com.gbizotto.wifimonitor.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ConnectionLog::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun connectionLogDao(): ConnectionLogDao
}