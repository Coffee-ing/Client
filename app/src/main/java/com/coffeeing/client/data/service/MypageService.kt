package com.coffeeing.client.data.service

import com.coffeeing.client.data.model.response.ResponseMyApply
import com.coffeeing.client.data.model.response.ResponseMyClub
import com.coffeeing.client.data.model.response.ResponseMyLike
import retrofit2.http.GET


interface MypageService {
    @GET("myclub/")
    suspend fun getMyClubList(): ResponseMyClub

    @GET("myapply/")
    suspend fun getMyApplyList(): ResponseMyApply

    @GET("mylike/")
    suspend fun getMyLikeList(): ResponseMyLike
}