package com.vadimkarch.dbpractice.task3.data.network.api

import retrofit2.Response
import retrofit2.http.GET


interface HttpCodeApi {

    @GET("status/200,400,401,403,404,500,502")
    suspend fun getRandomHttpCode(): Response<Void>
}