package dev.kevalkanpariya.educo.domain.model

import dev.kevalkanpariya.educo.R

data class Student(
    val name: String,
    val username: String,
    val avatar: Int,
    val banner: Int,
    val bio: String,
    val following: Int,
    val projects: Int,
    val courses: Int
)

val sudorizwan = Student(
    name = "Ahmed Rizwan",
    username = "sudo_rizwan",
    avatar = R.drawable.profile_image,
    banner = R.drawable.profile_banner,
    bio = "Android Engineer @Snappymob",
    following = 393,
    projects = 3,
    courses = 2

)

val keval = Student(
    name = "Keval Kanpariya",
    username = "keval.kanp.1011",
    avatar = R.drawable.android_dev_profile_image,
    banner = R.drawable.android_dev_profile_banner,
    bio = "News and announcements for developers from the Android team",
    following = 284,
    projects = 3,
    courses = 2
)