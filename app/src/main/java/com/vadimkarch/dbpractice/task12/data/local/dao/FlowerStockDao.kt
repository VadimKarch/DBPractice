package com.vadimkarch.dbpractice.task12.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vadimkarch.dbpractice.task12.data.local.entity.FlowerStock
import kotlinx.coroutines.flow.Flow

@Dao
interface FlowerStockDao {

    @Insert
    suspend fun insertAll(flowerStocks: List<FlowerStock>)

    @Query("UPDATE flower_stocks SET available_quantity = available_quantity - :amount WHERE flower_id = :flowerId")
    suspend fun decreaseStockQuantity(flowerId: Long, amount: Int)

    @Query("SELECT * FROM flower_stocks")
    fun getAll(): Flow<List<FlowerStock>>

    @Query("SELECT * FROM flower_stocks WHERE flower_id = :flowerId")
    fun getByFlowerId(flowerId: Long): FlowerStock
}