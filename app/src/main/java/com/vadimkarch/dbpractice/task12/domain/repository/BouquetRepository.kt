package com.vadimkarch.dbpractice.task12.domain.repository

import com.vadimkarch.dbpractice.task12.data.model.BouquetInfo
import kotlinx.coroutines.flow.Flow

interface BouquetRepository {

    fun getAvailableBouquetsInfo(): Flow<List<BouquetInfo>>

    suspend fun buyBouquet(bouquetId: Long): Boolean
}