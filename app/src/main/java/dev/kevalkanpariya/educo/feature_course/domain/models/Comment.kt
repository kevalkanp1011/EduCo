package dev.kevalkanpariya.educo.feature_course.domain.models

data class Comment(
    val id: String,
    val username: String,
    val user_photo_url: String,
    val comment: String
)
