package com.coffeeing.client.domain.repository

import com.coffeeing.client.domain.model.DetailCoffeeing
import com.coffeeing.client.domain.model.HomeCoffeeing


interface HomeRepository {
    suspend fun getHomeList(): Result<List<HomeCoffeeing>>
    suspend fun getCoffeeingDetail(postId: Int): Result<DetailCoffeeing>
}