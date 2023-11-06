package com.coffeeing.client.data.datasource.remote

import com.coffeeing.client.data.model.request.RequestDummy
import com.coffeeing.client.data.model.response.ResponseDummy
import com.coffeeing.client.data.service.DummyService
import javax.inject.Inject

class DummyDataSource @Inject constructor(
    private val dummyService: DummyService,
) {
    suspend fun uploadDummy(requestDummy: RequestDummy): ResponseDummy =
        dummyService.uploadDummy(requestDummy)
}