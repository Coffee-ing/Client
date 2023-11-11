package com.coffeeing.client.data.model.response

import android.media.Image
import com.coffeeing.client.domain.model.MyClub
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyClub(
    val coffeeingList: List<MyClub>
) {
    @Serializable
    data class MyClub(
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

    fun toMyClub() = coffeeingList.map { myclub ->
        com.coffeeing.client.domain.model.MyClub(
            id = myclub.id,
            image = myclub.image,
            title = myclub.title,
            content = myclub.content,
            num_people = myclub.num_people,
            district = myclub.district,
            meet_time = myclub.meet_time,
            deadline_yy = myclub.deadline_yy,
            deadline_mm = myclub.deadline_mm,
            deadline_dd = myclub.deadline_dd,
            organizer = myclub.organizer,
            like = myclub.like,
            iflike = myclub.iflike,
            tag = myclub.tag
        )
    }
}
