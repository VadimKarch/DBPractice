package com.vadimkarch.dbpractice.task12.domain.useCase

import com.vadimkarch.dbpractice.task12.data.model.BouquetInfo
import com.vadimkarch.dbpractice.task12.domain.repository.BouquetRepository
import kotlinx.coroutines.flow.Flow

class GetAvailableBouquetsInfoUseCase(private val repository: BouquetRepository) {

    operator fun invoke(): Flow<List<BouquetInfo>> =
        repository.getAvailableBouquetsInfo()
}