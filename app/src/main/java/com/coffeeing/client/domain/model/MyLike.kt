package com.coffeeing.client.domain.model

data class MyLike (
    val club_id: String,
    val id: Int,
    val image: String,
    val title: String,
    val content: String,
    val num_people: Int,
    val district: String,
    val meet_time: String,
    val deadline_yy: Int,
    val deadline_mm: String,
    val deadline_dd: String,
    val organizer: String,
    val like: Int,
    val iflike: Boolean,
    val tag: String
)