package com.coffeeing.client.data.datasource.remote

import com.coffeeing.client.data.model.request.RequestWriteCoffeeing
import com.coffeeing.client.data.model.response.ResponseCoffeeingDetail
import com.coffeeing.client.data.model.response.ResponseHomeList
import com.coffeeing.client.data.model.response.ResponseLike
import com.coffeeing.client.data.model.response.ResponseRegistration
import com.coffeeing.client.data.model.response.ResponseWriteCoffeeing
import com.coffeeing.client.data.service.MainService
import javax.inject.Inject

class MainDataSource @Inject constructor(
    private val mainService: MainService,
) {
    suspend fun getHomeList(): ResponseHomeList = mainService.getHomeList()
    suspend fun getCoffeeingDetail(postId: Int): ResponseCoffeeingDetail =
        mainService.getCoffeeingDetail(postId)

    suspend fun postCoffeeing(
        postId: Int,
        requestWriteCoffeeing: RequestWriteCoffeeing
    ): ResponseWriteCoffeeing = mainService.postCoffeeing(postId, requestWriteCoffeeing)

    suspend fun postLike(
        postId: Int
    ): ResponseLike = mainService.postLike(postId)

    suspend fun postRegistration(
        postId: Int
    ): ResponseRegistration = mainService.postRegistration(postId)

    suspend fun getSearch(
        keyword: String
    ): ResponseHomeList = mainService.getSearch(keyword)
}