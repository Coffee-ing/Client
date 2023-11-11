package com.coffeeing.client.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestWriteCoffeeing(
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
)