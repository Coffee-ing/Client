package com.coffeeing.client.domain.repository

import com.coffeeing.client.domain.model.CoffeeingMypage
import com.coffeeing.client.domain.model.MyClub

interface MypageRepository {
    suspend fun getMyClub(): Result<List<MyClub>>
}