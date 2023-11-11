package com.coffeeing.client.data.datasource.remote

import com.coffeeing.client.data.model.response.ResponseMyApply
import com.coffeeing.client.data.model.response.ResponseMyClub
import com.coffeeing.client.data.model.response.ResponseMyLike
import com.coffeeing.client.data.service.MypageService
import javax.inject.Inject

class MypageDataSource  @Inject constructor(
    private val mypageService: MypageService,
) {
    suspend fun getMyClubList(): ResponseMyClub = mypageService.getMyClubList()
    suspend fun getMyApplyList(): ResponseMyApply = mypageService.getMyApplyList()
    suspend fun getMyLikeList(): ResponseMyLike = mypageService.getMyLikeList()
}