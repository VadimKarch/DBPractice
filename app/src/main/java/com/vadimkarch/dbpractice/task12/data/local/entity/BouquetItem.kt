package com.vadimkarch.dbpractice.task12.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "bouquet_items",
    foreignKeys = [
        ForeignKey(
            entity = Bouquet::class,
            parentColumns = ["id"],
            childColumns = ["bouquet_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Flower::class,
            parentColumns = ["id"],
            childColumns = ["flower_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["bouquet_id"]),
        Index(value = ["flower_id"]),
    ]
)
data class BouquetItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "bouquet_id")
    val bouquetId: Long,
    @ColumnInfo(name = "flower_id")
    val flowerId: Long,
    @ColumnInfo(name = "required_quantity")
    val requiredQuantity: Int
)
