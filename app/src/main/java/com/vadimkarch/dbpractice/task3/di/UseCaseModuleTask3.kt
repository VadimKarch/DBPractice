package com.vadimkarch.dbpractice.task3.di

import com.vadimkarch.dbpractice.task3.domain.useCase.GetRandomHttpCodeUseCase
import org.koin.dsl.module

val useCaseModuleTask3 = module {
    factory { GetRandomHttpCodeUseCase(httpCodeRepository = get()) }
}