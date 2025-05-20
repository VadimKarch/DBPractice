package com.vadimkarch.dbpractice.task12.domain.useCase

import com.vadimkarch.dbpractice.task12.domain.repository.BouquetRepository

class BuyBouquetUseCase(private val repository: BouquetRepository) {

    suspend operator fun invoke(bouquetId: Long): Boolean =
        repository.buyBouquet(bouquetId)
}