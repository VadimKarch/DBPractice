package com.vadimkarch.dbpractice.task12.di

import com.vadimkarch.dbpractice.task12.domain.useCase.BuyBouquetUseCase
import com.vadimkarch.dbpractice.task12.domain.useCase.GetAvailableBouquetsInfoUseCase
import org.koin.dsl.module

val useCaseModuleTask12 = module {
    factory { GetAvailableBouquetsInfoUseCase(repository = get()) }
    factory { BuyBouquetUseCase(repository = get()) }
}