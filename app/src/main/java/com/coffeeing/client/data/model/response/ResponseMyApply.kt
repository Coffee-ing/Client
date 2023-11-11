package com.coffeeing.client.data.model.response

import com.coffeeing.client.domain.model.MyApply
import com.coffeeing.client.domain.model.MyClub
import kotlinx.serialization.Serializable
@Serializable
data class ResponseMyApply (
    val coffeeingList: List<MyApply>
) {
    @Serializable
    data class MyApply(
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

    fun toMyApply() = coffeeingList.map { myapply ->
        MyApply(
            club_id = myapply.club_id,
            id = myapply.club.id,
            image = myapply.club.image,
            title = myapply.club.title,
            content = myapply.club.content,
            num_people = myapply.club.num_people,
            district = myapply.club.district,
            meet_time = myapply.club.meet_time,
            deadline_yy = myapply.club.deadline_yy,
            deadline_mm = myapply.club.deadline_mm,
            deadline_dd = myapply.club.deadline_dd,
            organizer = myapply.club.organizer,
            like = myapply.club.like,
            iflike = myapply.club.iflike,
            tag = myapply.club.tag
        )
    }
}
