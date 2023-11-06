package com.coffeeing.client.data.repository

import com.coffeeing.client.data.datasource.remote.DummyDataSource
import com.coffeeing.client.data.model.request.RequestDummy
import com.coffeeing.client.domain.model.DummyData
import com.coffeeing.client.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyDataSource: DummyDataSource,
) : DummyRepository {
    override suspend fun uploadDummy(name: String, email: String): Result<DummyData> =
        runCatching {
            dummyDataSource.uploadDummy(RequestDummy(name, email)).data.toDummyData()
        }
}