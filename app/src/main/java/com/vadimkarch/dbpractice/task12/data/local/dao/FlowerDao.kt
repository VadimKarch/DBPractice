package com.vadimkarch.dbpractice.task12.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vadimkarch.dbpractice.task12.data.local.entity.Flower
import kotlinx.coroutines.flow.Flow

@Dao
interface FlowerDao {

    @Insert
    suspend fun insertAll(flowers: List<Flower>)

    @Query("SELECT * FROM flowers")
    fun getAll(): Flow<List<Flower>>
}