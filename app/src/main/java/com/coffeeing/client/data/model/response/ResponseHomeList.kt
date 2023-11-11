package com.coffeeing.client.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeList(
    val coffeeingList: List<Coffeeing>
) {
    @Serializable
    data class Coffeeing(
        val id: Int,
        val image: String,
        val title: String,
        val content: String,
        @SerialName("num_people")
        val numPeople: Int,
        val district: String,
        @SerialName("meet_time")
        val meetTime: String,
        @SerialName("deadline_yy")
        val deadlineYY: String,
        @SerialName("deadline_mm")
        val deadlineMM: String,
        @SerialName("deadline_dd")
        val deadlineDD: String,
        val organizer: String,
        val like: Int,
        val iflike: Boolean,
        val tag: String
    )

    fun toHomeList() = coffeeingList.map { home ->
        com.coffeeing.client.domain.model.HomeCoffeeing(
            id = home.id,
            image = home.image,
            title = home.title,
            numPeople = home.numPeople,
            district = home.district,
            meetTime = home.meetTime,
            like = home.like,
            iflike = home.iflike,
            tag = home.tag
        )
    }
}