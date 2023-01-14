package dev.kevalkanpariya.featuretesteduco.domain.model

@kotlinx.serialization.Serializable
data class Teacher(
    val name: String,
    val bio: String? = null,
    val instaLink: String
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