package com.vadimkarch.dbpractice.task3.domain.repository

interface HttpCodeRepository {

    suspend fun getRandomHttpCode()
}