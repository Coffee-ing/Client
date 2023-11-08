package com.coffeeing.client.domain.model

data class Coffeeing(
    val coffeeingId: Int,
    val coffeeingImg: String,
    val title: String,
    val location: String,
    val time: String,
    val person: Int,
    val isHearted: Boolean,
    val heartCount: Int,
    val isBaristaOriginal: Boolean,
    val isLocalArea: Boolean,
    val isHotPlace: Boolean,
    val isProfessional: Boolean,
    val isBiginner: Boolean
)
