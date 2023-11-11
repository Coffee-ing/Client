package com.coffeeing.client.data.repository

import com.coffeeing.client.data.datasource.remote.MainDataSource
import com.coffeeing.client.data.model.request.RequestWriteCoffeeing
import com.coffeeing.client.domain.model.DetailCoffeeing
import com.coffeeing.client.domain.model.HomeCoffeeing
import com.coffeeing.client.domain.model.Like
import com.coffeeing.client.domain.model.WriteCoffeeing
import com.coffeeing.client.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource,
) : MainRepository {
    override suspend fun getHomeList(): Result<List<HomeCoffeeing>> = runCatching {
        mainDataSource.getHomeList().toHomeList()
    }

    override suspend fun getCoffeeingDetail(postId: Int): Result<DetailCoffeeing> = runCatching {
        mainDataSource.getCoffeeingDetail(postId).toDetailCoffeeing()
    }

    override suspend fun postCoffeeing(
        postId: Int,
        requestWriteCoffeeing: RequestWriteCoffeeing
    ): Result<WriteCoffeeing> =
        runCatching {
            mainDataSource.postCoffeeing(postId, requestWriteCoffeeing).toWriteCoffeeing()
        }

    override suspend fun postLike(postId: Int): Result<Like> = runCatching {
        mainDataSource.postLike(postId).toLike()
    }
}