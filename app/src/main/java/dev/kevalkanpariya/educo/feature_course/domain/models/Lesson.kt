package dev.kevalkanpariya.educo.feature_course.domain.models

import dev.kevalkanpariya.educo.R
import kotlinx.serialization.Serializable

@Serializable
data class Lesson(
    val name: String,
    val thumbnail: Int,
    val desc: String
)


val adobelesson1 = Lesson(
    name = "Start",
    thumbnail = R.drawable.interiordesign,
    desc = " Interior Design Course For Begginer"
)
val adobelesson2 = Lesson(
    name = "Pause",
    thumbnail = R.drawable.interiordesign,
    desc = " Interior Design Course For Begginer"
)
val adobelesson3 = Lesson(
    name = "End",
    thumbnail = R.drawable.interiordesign,
    desc = "Interior Design Course For Begginer"
)

val adobeLessons = listOf(adobelesson1, adobelesson2, adobelesson3)

val androidlesson1 = Lesson(
    name = "Start",
    thumbnail = R.drawable.interiordesign,
    desc = "Android development Course For Begginer"
)
val androidlesson2 = Lesson(
    name = "Pause",
    thumbnail = R.drawable.interiordesign,
    desc = "Android Development Course For Begginer"
)
val androidlesson3 = Lesson(
    name = "End",
    thumbnail = R.drawable.interiordesign,
    desc = "Android development Course For Begginer"
)

val androidLessons = listOf(androidlesson1, androidlesson2, androidlesson3)

val canvalesson1 = Lesson(
    name = "Start",
    thumbnail = R.drawable.interiordesign,
    desc = " Canva Design Course For Begginer"
)
val canvalesson2 = Lesson(
    name = "Pause",
    thumbnail = R.drawable.interiordesign,
    desc = " Canva Design Course For Begginer"
)
val canvalesson3 = Lesson(
    name = "End",
    thumbnail = R.drawable.interiordesign,
    desc = " Canva Design Course For Begginer"
)

val canvaLessons = listOf(canvalesson1, canvalesson2, canvalesson3)
