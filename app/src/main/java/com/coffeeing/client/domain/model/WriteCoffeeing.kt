package com.coffeeing.client.domain.model

data class WriteCoffeeing(
    val title: String,
    val district: String,
    val meetTime: String,
    val numPeople: Int,
    val deadlineYY: Int,
    val deadlineMM: String,
    val deadlineDD: String,
    val tag: String,
    val content: String
)
