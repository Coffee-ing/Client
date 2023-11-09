package com.coffeeing.client.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class CoffeeingInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val headerRequest = originalRequest.newBuilder().build()
        val response = chain.proceed(headerRequest)

        when (response.code) {
            401 -> {
                // TODO 토큰 재발급 api 연동
            }
        }
        return response
    }
}