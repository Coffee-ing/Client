package com.coffeeing.client.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
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
) : Parcelable {
    @Parcelize
    data class Writer(
        val nickname: String,
        val numberOfRecruit: Int
    ) : Parcelable
}
