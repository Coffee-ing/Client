package com.coffeeing.client.domain.repository

import com.coffeeing.client.data.model.request.RequestWriteCoffeeing
import com.coffeeing.client.domain.model.DetailCoffeeing
import com.coffeeing.client.domain.model.HomeCoffeeing
import com.coffeeing.client.domain.model.Like
import com.coffeeing.client.domain.model.Registration
import com.coffeeing.client.domain.model.WriteCoffeeing


interface MainRepository {
    suspend fun getHomeList(): Result<List<HomeCoffeeing>>
    suspend fun getCoffeeingDetail(postId: Int): Result<DetailCoffeeing>
    suspend fun postCoffeeing(
        postId: Int,
        requestWriteCoffeeing: RequestWriteCoffeeing
    ): Result<WriteCoffeeing>

    suspend fun postLike(
        postId: Int
    ): Result<Like>

    suspend fun postRegistration(
        postId: Int
    ): Result<Registration>

    suspend fun getSearch(
        keyword: String
    ): Result<List<HomeCoffeeing>>
}