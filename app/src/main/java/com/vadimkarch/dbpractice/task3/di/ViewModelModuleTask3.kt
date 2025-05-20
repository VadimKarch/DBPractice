package com.vadimkarch.dbpractice.task3.di

import com.vadimkarch.dbpractice.task3.presentation.Task3ViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModuleTask3 = module {
    viewModel { Task3ViewModel(getRandomHttpCodeUseCase = get()) }
}