package com.coffeeing.client.data.service

import com.coffeeing.client.data.model.request.RequestWriteCoffeeing
import com.coffeeing.client.data.model.response.ResponseCoffeeingDetail
import com.coffeeing.client.data.model.response.ResponseHomeList
import com.coffeeing.client.data.model.response.ResponseLike
import com.coffeeing.client.data.model.response.ResponseRegistration
import com.coffeeing.client.data.model.response.ResponseWriteCoffeeing
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MainService {
    @GET("list")
    suspend fun getHomeList(): ResponseHomeList

    @GET("list/{post_id}/")
    suspend fun getCoffeeingDetail(
        @Path("post_id") postId: Int
    ): ResponseCoffeeingDetail

    @POST("list/{post_id}")
    suspend fun postCoffeeing(
        @Path("post_id") postId: Int,
        @Body requestWriteCoffeeing: RequestWriteCoffeeing
    ): ResponseWriteCoffeeing

    @GET("like/{post_id}")
    suspend fun postLike(
        @Path("post_id") postId: Int
    ): ResponseLike

    @GET("list/registration/{post_id}")
    suspend fun postRegistration(
        @Path("post_id") postId: Int
    ): ResponseRegistration

    @GET("search")
    suspend fun getSearch(
        @Query("keyword") keyword: String
    ): ResponseHomeList

    @GET("sort")
    suspend fun getSort(
        @Query("sort") sort: String
    ): ResponseHomeList

    @GET("filter")
    suspend fun getFilter(
        @Query("tag") tag: String
    ): ResponseHomeList
}