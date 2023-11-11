package com.coffeeing.client.data.repository

import com.coffeeing.client.data.datasource.remote.MypageDataSource
import com.coffeeing.client.domain.model.MyApply
import com.coffeeing.client.domain.model.MyClub
import com.coffeeing.client.domain.model.MyLike
import com.coffeeing.client.domain.repository.MypageRepository
import javax.inject.Inject

class MypageRepositoryImpl @Inject constructor(
    private val mypageDataSource: MypageDataSource,
) : MypageRepository {
    override suspend fun getMyClub(): Result<List<MyClub>> = runCatching {
        mypageDataSource.getMyClubList().toMyClub()
    }
    override suspend fun getMyApply(): Result<List<MyApply>> = runCatching {
        mypageDataSource.getMyApplyList().toMyApply()
    }
    override suspend fun getMyLike(): Result<List<MyLike>> = runCatching {
        mypageDataSource.getMyLikeList().toMyLike()
    }
}