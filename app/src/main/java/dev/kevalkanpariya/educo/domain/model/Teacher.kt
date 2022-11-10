package dev.kevalkanpariya.educo.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Teacher(
    val name: String,
    val instaLink: String,
    val facebookLink: String? = null,
    val twitterLink: String? = null
)

val kevalkanpariya = Teacher(
    name = "Keval Kanpariya",
    instaLink = "http://www.instagram.com/keval.kanp.1011/"
)

val hetdesai = Teacher(
    name = "Het Desai",
    instaLink = "http://www.instagram.com/keval.kanp.1011/"
)

val krishnaKhandelwal = Teacher(
    name = "Krishna Khandelwal",
    instaLink = "http://www.instagram.com/keval.kanp.1011/"
)