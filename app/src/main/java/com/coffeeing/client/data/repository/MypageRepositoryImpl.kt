package com.coffeeing.client.data.repository

import com.coffeeing.client.data.datasource.remote.MypageDataSource
import com.coffeeing.client.domain.model.CoffeeingMypage
import com.coffeeing.client.domain.model.MyClub
import com.coffeeing.client.domain.repository.MypageRepository
import javax.inject.Inject

class MypageRepositoryImpl @Inject constructor(
    private val mypageDataSource: MypageDataSource,
) : MypageRepository {
    override suspend fun getMyClub(): Result<List<MyClub>> = runCatching {
        mypageDataSource.getMyClubList().toMyClub()
    }
}