package com.vadimkarch.dbpractice.task12.di

import com.vadimkarch.dbpractice.task12.data.local.db.BouquetDatabase
import org.koin.dsl.module

val databaseModuleTask12 = module {
    single { BouquetDatabase.getInstance(context = get()) }
}