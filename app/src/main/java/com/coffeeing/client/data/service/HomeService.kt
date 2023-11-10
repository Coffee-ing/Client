package com.coffeeing.client.data.service

import com.coffeeing.client.data.model.response.ResponseCoffeeingDetail
import com.coffeeing.client.data.model.response.ResponseHomeList
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {
    @GET("list")
    suspend fun getHomeList(): ResponseHomeList

    @GET("list/{post_id}/")
    suspend fun getCoffeeingDetail(
        @Path("post_id") postId: Int
    ): ResponseCoffeeingDetail
}