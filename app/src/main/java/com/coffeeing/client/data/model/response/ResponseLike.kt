package com.coffeeing.client.data.model.response

import com.coffeeing.client.domain.model.Like
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseLike(
    @SerialName("Number of likes")
    val numberOfLikes: Int,
    @SerialName("Like it or not")
    val likeItOrNot: Boolean
) {
    fun toLike() = Like(
        numberOfLikes = this.numberOfLikes,
        likeInOrNot = this.likeItOrNot
    )
}