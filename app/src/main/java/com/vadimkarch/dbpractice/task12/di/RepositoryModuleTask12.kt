package com.vadimkarch.dbpractice.task12.di

import com.vadimkarch.dbpractice.task12.data.repository.BouquetRepositoryImpl
import com.vadimkarch.dbpractice.task12.domain.repository.BouquetRepository
import org.koin.dsl.module

val repositoryModuleTask12 = module {
    single<BouquetRepository> {
        BouquetRepositoryImpl(
            database = get()
        )
    }
}