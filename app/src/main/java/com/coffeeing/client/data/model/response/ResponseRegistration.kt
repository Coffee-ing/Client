package com.coffeeing.client.data.model.response

import com.coffeeing.client.domain.model.Registration
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRegistration(
    val message: String
) {
    fun toRegistration() = Registration(
        message = this.message
    )
}