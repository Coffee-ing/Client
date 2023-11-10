package com.coffeeing.client.data.service

import com.coffeeing.client.data.model.response.ResponseHomeList
import retrofit2.http.GET

interface HomeService {
    @GET("list")
    suspend fun getHomeList(): ResponseHomeList
}