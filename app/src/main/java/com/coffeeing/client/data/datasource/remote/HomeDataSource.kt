package com.coffeeing.client.data.datasource.remote

import com.coffeeing.client.data.model.response.ResponseHomeList
import com.coffeeing.client.data.service.HomeService
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val homeService: HomeService,
) {
    suspend fun getHomeList(): ResponseHomeList = homeService.getHomeList()
}