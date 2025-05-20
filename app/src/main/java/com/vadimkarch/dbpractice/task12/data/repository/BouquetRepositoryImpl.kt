package com.vadimkarch.dbpractice.task12.data.repository

import androidx.room.withTransaction
import com.vadimkarch.dbpractice.task12.data.local.dao.BouquetWithItemsDao
import com.vadimkarch.dbpractice.task12.data.local.dao.FlowerDao
import com.vadimkarch.dbpractice.task12.data.local.dao.FlowerStockDao
import com.vadimkarch.dbpractice.task12.data.local.db.BouquetDatabase
import com.vadimkarch.dbpractice.task12.data.model.BouquetInfo
import com.vadimkarch.dbpractice.task12.domain.repository.BouquetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class BouquetRepositoryImpl(private val database: BouquetDatabase) : BouquetRepository {

    private val flowerDao: FlowerDao = database.flowerDao()
    private val flowerStockDao: FlowerStockDao = database.flowerStockDao()
    private val bouquetWithItemsDao: BouquetWithItemsDao = database.bouquetWithItemsDao()

    override fun getAvailableBouquetsInfo(): Flow<List<BouquetInfo>> {
        return combine(
            flowerDao.getAll(),
            flowerStockDao.getAll(),
            bouquetWithItemsDao.getAll()
        ) { flowers, flowerStocks, bouquetsWithItems ->

            bouquetsWithItems.map { bouquetWithItems ->
                var totalPrice = 0.0
                var minAvailableQuantity = Int.MAX_VALUE

                bouquetWithItems.items.forEach { bouquetItem ->
                    val flowerPrice =
                        flowers.firstOrNull { it.id == bouquetItem.flowerId }?.price ?: 0.0

                    totalPrice += flowerPrice * bouquetItem.requiredQuantity

                    val availableFlowerQuantity =
                        flowerStocks.firstOrNull { it.flowerId == bouquetItem.flowerId }
                            ?.availableQuantity ?: 0

                    val availableSets =
                        availableFlowerQuantity / bouquetItem.requiredQuantity

                    if (availableSets < availableFlowerQuantity) {
                        minAvailableQuantity = availableSets
                    }
                }

                BouquetInfo(
                    bouquet = bouquetWithItems.bouquet,
                    items = bouquetWithItems.items,
                    price = totalPrice,
                    availableQuantity = minAvailableQuantity
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun buyBouquet(bouquetId: Long): Boolean {
        return withContext(Dispatchers.IO) {
            database.withTransaction {
                val bouquetWithItems = bouquetWithItemsDao.getByBouquetId(bouquetId)

                val hasEnoughFlowers = bouquetWithItems.items.all { bouquetItem ->
                    flowerStockDao.getByFlowerId(bouquetItem.flowerId).availableQuantity >=
                            bouquetItem.requiredQuantity
                }

                if (!hasEnoughFlowers) return@withTransaction false

                bouquetWithItems.items.forEach { bouquetItem ->
                    flowerStockDao.decreaseStockQuantity(
                        bouquetItem.flowerId,
                        bouquetItem.requiredQuantity
                    )
                }

                return@withTransaction true
            }
        }
    }
}