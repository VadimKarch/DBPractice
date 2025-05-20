package com.vadimkarch.dbpractice.task12.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class BouquetWithItems(
    @Embedded
    val bouquet: Bouquet,
    @Relation(
        entity = BouquetItem::class,
        parentColumn = "id",
        entityColumn = "bouquet_id"
    )
    val items: List<BouquetItem>,
)