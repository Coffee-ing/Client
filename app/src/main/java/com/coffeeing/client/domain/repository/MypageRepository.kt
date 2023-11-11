package com.coffeeing.client.domain.repository

import com.coffeeing.client.domain.model.CoffeeingMypage
import com.coffeeing.client.domain.model.MyApply
import com.coffeeing.client.domain.model.MyClub
import com.coffeeing.client.domain.model.MyLike

interface MypageRepository {
    suspend fun getMyClub(): Result<List<MyClub>>
    suspend fun getMyApply(): Result<List<MyApply>>
    suspend fun getMyLike(): Result<List<MyLike>>
}