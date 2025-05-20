package com.vadimkarch.dbpractice.task12.data.local.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {

    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE bouquets ADD COLUMN design TEXT NOT NULL DEFAULT 'Без оформления'")
        db.execSQL("UPDATE bouquets SET design = 'Крафтовая бумага' WHERE id = 1")
        db.execSQL("UPDATE bouquets SET design = 'Крафтовая бумага' WHERE id = 2")
        db.execSQL("UPDATE bouquets SET design = 'Корзина' WHERE id = 3")

        db.execSQL("ALTER TABLE flowers ADD COLUMN country TEXT NOT NULL DEFAULT 'Не указано'")
        db.execSQL("UPDATE flowers SET country = 'Голландия' WHERE id = 1")
        db.execSQL("UPDATE flowers SET country = 'Япония' WHERE id = 2")
        db.execSQL("UPDATE flowers SET country = 'Таиланд' WHERE id = 3")
        db.execSQL("UPDATE flowers SET country = 'Франция' WHERE id = 4")
        db.execSQL("UPDATE flowers SET country = 'Австралия' WHERE id = 5")
        db.execSQL("UPDATE flowers SET country = 'Голландия' WHERE id = 6")
    }
}