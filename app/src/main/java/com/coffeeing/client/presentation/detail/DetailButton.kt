package com.coffeeing.client.presentation.detail

import androidx.annotation.DrawableRes

data class DetailButton(
    @DrawableRes
    val button_num : Int, //이게 없으면 오류남
    val button_name: String,
)