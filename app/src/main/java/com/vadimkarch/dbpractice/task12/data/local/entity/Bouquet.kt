package com.vadimkarch.dbpractice.task12.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets")
data class Bouquet(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val design: String
)