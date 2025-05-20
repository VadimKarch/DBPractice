package com.vadimkarch.dbpractice.task3.di

import com.vadimkarch.dbpractice.task3.data.network.NetworkConstants
import com.vadimkarch.dbpractice.task3.data.network.api.HttpCodeApi
import com.vadimkarch.dbpractice.task3.data.network.interceptor.HttpCodeLoggingInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModuleTask3 = module {
    single {
        OkHttpClient
            .Builder()
            .addInterceptor(HttpCodeLoggingInterceptor())
            .build()
    }

    single {
        Retrofit
            .Builder()
            .baseUrl(NetworkConstants.HTTP_CODE_API_BASE_URL)
            .client(get<OkHttpClient>())
            .build()
    }

    single {
        get<Retrofit>().create(HttpCodeApi::class.java)
    }
}