package com.vadimkarch.dbpractice.task12.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vadimkarch.dbpractice.task12.data.local.dao.BouquetDao
import com.vadimkarch.dbpractice.task12.data.local.dao.BouquetItemDao
import com.vadimkarch.dbpractice.task12.data.local.dao.BouquetWithItemsDao
import com.vadimkarch.dbpractice.task12.data.local.dao.FlowerDao
import com.vadimkarch.dbpractice.task12.data.local.dao.FlowerStockDao
import com.vadimkarch.dbpractice.task12.data.local.entity.Bouquet
import com.vadimkarch.dbpractice.task12.data.local.entity.BouquetItem
import com.vadimkarch.dbpractice.task12.data.local.entity.Flower
import com.vadimkarch.dbpractice.task12.data.local.entity.FlowerStock
import com.vadimkarch.dbpractice.task12.data.local.migration.MIGRATION_1_2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    version = 2,
    entities = [
        Flower::class, FlowerStock::class,
        Bouquet::class, BouquetItem::class
    ]
)
abstract class BouquetDatabase : RoomDatabase() {

    abstract fun flowerDao(): FlowerDao
    abstract fun flowerStockDao(): FlowerStockDao
    abstract fun bouquetDao(): BouquetDao
    abstract fun bouquetItemDao(): BouquetItemDao
    abstract fun bouquetWithItemsDao(): BouquetWithItemsDao

    companion object {
        fun getInstance(context: Context): BouquetDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BouquetDatabase::class.java,
                "flower_shop.db"
            ).addCallback(
                object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        CoroutineScope(Dispatchers.IO).launch {
                            prepopulate(context)
                        }
                    }
                }
            )
                .addMigrations(MIGRATION_1_2)
                .build()
        }

        private suspend fun prepopulate(context: Context) {
            val database = getInstance(context)

            // country добавлены после добавления миграции
            database.flowerDao().insertAll(
                listOf(
                    Flower(id = 1, name = "Белая роза", country = "Голландия", price = 100.0),
                    Flower(id = 2, name = "Красная роза", country = "Япония", price = 110.0),
                    Flower(id = 3, name = "Тюльпан", country = "Таиланд", price = 90.0),
                    Flower(id = 4, name = "Ромашка", country = "Франция", price = 70.0),
                    Flower(id = 5, name = "Пионы", country = "Австралия", price = 80.0),
                    Flower(id = 6, name = "Гипсофилы", country = "Голландия", price = 60.0)
                )
            )

            database.flowerStockDao().insertAll(
                listOf(
                    FlowerStock(flowerId = 1, availableQuantity = 10),
                    FlowerStock(flowerId = 2, availableQuantity = 5),
                    FlowerStock(flowerId = 3, availableQuantity = 25),
                    FlowerStock(flowerId = 4, availableQuantity = 10),
                    FlowerStock(flowerId = 5, availableQuantity = 7),
                    FlowerStock(flowerId = 6, availableQuantity = 12),
                )
            )

            // design добавлены после добавления миграции
            database.bouquetDao().insertAll(
                listOf(
                    Bouquet(id = 1, name = "Весенний", design = "Крафтовая бумага"),
                    Bouquet(id = 2, name = "Гипсофиломания", design = "Крафтовая бумага"),
                    Bouquet(id = 3, name = "Просто и со вкусом", design = "Корзина")
                )
            )

            database.bouquetItemDao().insertAll(
                listOf(
                    BouquetItem(bouquetId = 1, flowerId = 1, requiredQuantity = 3),
                    BouquetItem(bouquetId = 1, flowerId = 2, requiredQuantity = 2),
                    BouquetItem(bouquetId = 1, flowerId = 3, requiredQuantity = 10),

                    BouquetItem(bouquetId = 2, flowerId = 6, requiredQuantity = 10),

                    BouquetItem(bouquetId = 3, flowerId = 3, requiredQuantity = 3),
                    BouquetItem(bouquetId = 3, flowerId = 4, requiredQuantity = 3),
                    BouquetItem(bouquetId = 3, flowerId = 5, requiredQuantity = 6),
                )
            )
        }
    }
}