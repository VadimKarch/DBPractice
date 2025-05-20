package com.vadimkarch.dbpractice.task12.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.vadimkarch.dbpractice.task12.data.local.entity.BouquetItem

@Dao
interface BouquetItemDao {

    @Insert
    suspend fun insertAll(bouquetItems: List<BouquetItem>)
}