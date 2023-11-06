package com.coffeeing.client.domain.repository

import com.coffeeing.client.domain.model.DummyData

interface DummyRepository {
    suspend fun uploadDummy(name: String, email: String): Result<DummyData>
}