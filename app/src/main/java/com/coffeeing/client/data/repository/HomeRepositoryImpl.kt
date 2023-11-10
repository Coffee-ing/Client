package com.coffeeing.client.data.repository

import com.coffeeing.client.data.datasource.remote.HomeDataSource
import com.coffeeing.client.domain.model.DetailCoffeeing
import com.coffeeing.client.domain.model.HomeCoffeeing
import com.coffeeing.client.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource,
) : HomeRepository {
    override suspend fun getHomeList(): Result<List<HomeCoffeeing>> = runCatching {
        homeDataSource.getHomeList().toHomeList()
    }

    override suspend fun getCoffeeingDetail(postId: Int): Result<DetailCoffeeing> = runCatching {
        homeDataSource.getCoffeeingDetail(postId).toDetailCoffeeing()
    }
}