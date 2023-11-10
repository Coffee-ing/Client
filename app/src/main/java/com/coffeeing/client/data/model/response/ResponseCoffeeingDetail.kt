package com.coffeeing.client.data.model.response

import com.coffeeing.client.domain.model.DetailCoffeeing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseCoffeeingDetail(
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
) {
    fun toDetailCoffeeing() = DetailCoffeeing(
        id = this.id,
        image = this.image,
        title = this.title,
        content = this.content,
        numPeople = this.numPeople,
        district = this.district,
        meetTime = this.meetTime,
        deadlineYY = this.deadlineYY,
        deadlineMM = this.deadlineMM,
        deadlineDD = this.deadlineDD,
        organizer = this.organizer,
        like = this.like,
        iflike = this.iflike,
        tag = this.tag
    )
}