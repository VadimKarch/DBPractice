package com.vadimkarch.dbpractice.task12.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.vadimkarch.dbpractice.task12.data.local.entity.Bouquet

@Dao
interface BouquetDao {

    @Insert
    suspend fun insertAll(bouquets: List<Bouquet>)
}