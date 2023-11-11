package com.coffeeing.client.data.model.response

import com.coffeeing.client.domain.model.MyClub
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyClub(
    val coffeeingList: List<MyClub>
) {
    @Serializable
    data class MyClub(
        val club_id: String,
        val club: Club
    ) {
        @Serializable
        data class Club(
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
    }

    fun toMyClub() = coffeeingList.map { myclub ->
        MyClub(
            club_id = myclub.club_id,
            id = myclub.club.id,
            image = myclub.club.image,
            title = myclub.club.title,
            content = myclub.club.content,
            num_people = myclub.club.num_people,
            district = myclub.club.district,
            meet_time = myclub.club.meet_time,
            deadline_yy = myclub.club.deadline_yy,
            deadline_mm = myclub.club.deadline_mm,
            deadline_dd = myclub.club.deadline_dd,
            organizer = myclub.club.organizer,
            like = myclub.club.like,
            iflike = myclub.club.iflike,
            tag = myclub.club.tag
        )
    }
}
