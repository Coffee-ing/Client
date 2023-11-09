package com.coffeeing.client.domain.model

import com.coffeeing.client.presentation.model.Coffeeing

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
    val isBeginner: Boolean,
    val closingDate: String,
    val context: String,
    val writer: Writer
) {
    data class Writer(
        val nickname: String,
        val numberOfRecruit: Int
    )

    fun toParcelizeCoffeeing() = Coffeeing(
        coffeeingId = this.coffeeingId,
        coffeeingImg = this.coffeeingImg,
        title = this.title,
        location = this.location,
        time = this.time,
        person = this.person,
        isHearted = this.isHearted,
        heartCount = this.heartCount,
        isBaristaOriginal = this.isBaristaOriginal,
        isLocalArea = this.isLocalArea,
        isHotPlace = this.isHotPlace,
        isProfessional = this.isProfessional,
        isBeginner = this.isBeginner,
        closingDate = this.closingDate,
        context = this.context,
        writer = Coffeeing.Writer(
            nickname = this.writer.nickname,
            numberOfRecruit = this.writer.numberOfRecruit
        )
    )
}
