package com.vadimkarch.dbpractice.task3.data.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class HttpCodeLoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        Log.d(TAG, response.code.toString())

        return response
    }

    companion object {
        private const val TAG = "HttpCodeLoggingInterceptor"
    }
}