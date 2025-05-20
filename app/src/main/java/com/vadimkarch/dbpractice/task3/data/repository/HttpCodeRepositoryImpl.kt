package com.vadimkarch.dbpractice.task3.data.repository

import com.vadimkarch.dbpractice.task3.data.network.api.HttpCodeApi
import com.vadimkarch.dbpractice.task3.domain.repository.HttpCodeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HttpCodeRepositoryImpl(private val httpCodeApi: HttpCodeApi) : HttpCodeRepository {

    override suspend fun getRandomHttpCode() {
        withContext(Dispatchers.IO) {
            httpCodeApi.getRandomHttpCode()
        }
    }
}