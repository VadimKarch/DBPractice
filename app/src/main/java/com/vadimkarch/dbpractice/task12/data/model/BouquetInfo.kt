package com.vadimkarch.dbpractice.task12.data.model

import com.vadimkarch.dbpractice.task12.data.local.entity.Bouquet
import com.vadimkarch.dbpractice.task12.data.local.entity.BouquetItem

data class BouquetInfo(
    val bouquet: Bouquet,
    val items: List<BouquetItem>,
    val availableQuantity: Int,
    val price: Double
)
