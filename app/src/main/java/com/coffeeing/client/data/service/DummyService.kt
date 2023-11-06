package com.coffeeing.client.data.service

import com.coffeeing.client.data.model.request.RequestDummy
import com.coffeeing.client.data.model.response.ResponseDummy
import retrofit2.http.Body
import retrofit2.http.POST

interface DummyService {
    @POST("api/dummy")
    suspend fun uploadDummy(@Body request: RequestDummy): ResponseDummy
}