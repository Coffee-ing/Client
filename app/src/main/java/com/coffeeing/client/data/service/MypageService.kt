package com.coffeeing.client.data.service

import com.coffeeing.client.data.model.response.ResponseMyClub
import retrofit2.http.GET


interface MypageService {
    @GET("myclub/")
    suspend fun getMyClubList(): ResponseMyClub
}