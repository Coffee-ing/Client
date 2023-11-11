package com.coffeeing.client.data.model.response

import com.coffeeing.client.domain.model.MyClub
import com.coffeeing.client.domain.model.MyLike
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNull.content

@Serializable
data class ResponseMyLike(
    val coffeeingList: List<MyLike>
) {
    @Serializable
    data class MyLike(
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

    fun toMyLike() = coffeeingList.map { mylike ->
        MyLike(
            club_id = mylike.club_id,
            id = mylike.club.id,
            image = mylike.club.image,
            title = mylike.club.title,
            content = mylike.club.content,
            num_people = mylike.club.num_people,
            district = mylike.club.district,
            meet_time = mylike.club.meet_time,
            deadline_yy = mylike.club.deadline_yy,
            deadline_mm = mylike.club.deadline_mm,
            deadline_dd = mylike.club.deadline_dd,
            organizer = mylike.club.organizer,
            like = mylike.club.like,
            iflike = mylike.club.iflike,
            tag = mylike.club.tag
        )
    }
}

