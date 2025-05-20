package com.vadimkarch.dbpractice.task3.di

import com.vadimkarch.dbpractice.task3.data.repository.HttpCodeRepositoryImpl
import com.vadimkarch.dbpractice.task3.domain.repository.HttpCodeRepository
import org.koin.dsl.module

val repositoryModuleTask3 = module {
    single<HttpCodeRepository> { HttpCodeRepositoryImpl(httpCodeApi = get()) }
}