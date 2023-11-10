package com.coffeeing.client.data.repository

import com.coffeeing.client.data.datasource.remote.MainDataSource
import com.coffeeing.client.domain.model.DetailCoffeeing
import com.coffeeing.client.domain.model.HomeCoffeeing
import com.coffeeing.client.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val homeDataSource: MainDataSource,
) : MainRepository {
    override suspend fun getHomeList(): Result<List<HomeCoffeeing>> = runCatching {
        homeDataSource.getHomeList().toHomeList()
    }

    override suspend fun getCoffeeingDetail(postId: Int): Result<DetailCoffeeing> = runCatching {
        homeDataSource.getCoffeeingDetail(postId).toDetailCoffeeing()
    }
}