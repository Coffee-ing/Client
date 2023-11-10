package com.coffeeing.client.domain.model

data class DetailCoffeeing(
    val id: Int,
    val image: String,
    val title: String,
    val content: String,
    val numPeople: Int,
    val district: String,
    val meetTime: String,
    val deadlineYY: String,
    val deadlineMM: String,
    val deadlineDD: String,
    val organizer: String,
    val like: Int,
    val iflike: Boolean,
    val tag: String
)