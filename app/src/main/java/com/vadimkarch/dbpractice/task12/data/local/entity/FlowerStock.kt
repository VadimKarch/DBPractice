package com.vadimkarch.dbpractice.task12.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "flower_stocks",
    foreignKeys = [
        ForeignKey(
            entity = Flower::class,
            parentColumns = ["id"],
            childColumns = ["flower_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FlowerStock(
    @PrimaryKey
    @ColumnInfo("flower_id")
    val flowerId: Long = 0,
    @ColumnInfo("available_quantity")
    val availableQuantity: Int
)
