package com.coffeeing.client.data.datasource.remote

import com.coffeeing.client.data.model.response.ResponseCoffeeingDetail
import com.coffeeing.client.data.model.response.ResponseHomeList
import com.coffeeing.client.data.service.MainService
import javax.inject.Inject

class MainDataSource @Inject constructor(
    private val homeService: MainService,
) {
    suspend fun getHomeList(): ResponseHomeList = homeService.getHomeList()
    suspend fun getCoffeeingDetail(postId: Int): ResponseCoffeeingDetail =
        homeService.getCoffeeingDetail(postId)
}