package com.vadimkarch.dbpractice.task12.di

import com.vadimkarch.dbpractice.task12.presentation.Task12ViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModuleTask12 = module {
    viewModel {
        Task12ViewModel(
            getAvailableBouquetsInfoUseCase = get(),
            buyBouquetUseCase = get()
        )
    }
}