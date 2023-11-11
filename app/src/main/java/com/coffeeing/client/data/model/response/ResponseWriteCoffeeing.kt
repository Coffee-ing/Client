package com.coffeeing.client.data.model.response

import com.coffeeing.client.domain.model.WriteCoffeeing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseWriteCoffeeing(
    val title: String,
    val district: String,
    @SerialName("meet_time")
    val meetTime: String,
    @SerialName("num_people")
    val numPeople: Int,
    @SerialName("deadline_yy")
    val deadlineYY: Int,
    @SerialName("deadline_mm")
    val deadlineMM: String,
    @SerialName("deadline_dd")
    val deadlineDD: String,
    val tag: String,
    val content: String
) {
    fun toWriteCoffeeing() = WriteCoffeeing(
        title = this.title,
        district = this.district,
        meetTime = this.meetTime,
        numPeople = this.numPeople,
        deadlineYY = this.deadlineYY,
        deadlineMM = this.deadlineMM,
        deadlineDD = this.deadlineDD,
        tag = this.tag,
        content = this.content
    )
}