package com.vadimkarch.dbpractice.task3.domain.useCase

import com.vadimkarch.dbpractice.task3.domain.repository.HttpCodeRepository

class GetRandomHttpCodeUseCase(private val httpCodeRepository: HttpCodeRepository) {

    suspend fun invoke() {
        httpCodeRepository.getRandomHttpCode()
    }
}