package com.vadimkarch.dbpractice.task12.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.vadimkarch.dbpractice.task12.data.local.entity.BouquetWithItems
import kotlinx.coroutines.flow.Flow

@Dao
interface BouquetWithItemsDao {

    @Transaction
    @Query("SELECT * FROM bouquets")
    fun getAll(): Flow<List<BouquetWithItems>>

    @Transaction
    @Query("SELECT * FROM bouquets WHERE id = :bouquetId")
    fun getByBouquetId(bouquetId: Long): BouquetWithItems
}