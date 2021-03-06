package com.gbizotto.wifimonitor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConnectionLogDao {

    @Query("SELECT * FROM logs ORDER BY id DESC")
    fun getAll(): List<ConnectionLog>

    @Insert
    fun insertAll(vararg logs: ConnectionLog)
}