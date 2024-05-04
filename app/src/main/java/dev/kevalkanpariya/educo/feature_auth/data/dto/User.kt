package dev.kevalkanpariya.educo.feature_auth.data.dto

data class User(
    val id: String,
    val name: String = "",
    val photo_url: String = "",
    val count_enrolled: Int = 0,
    val count_following: Int = 0,
    val count_followers: Int = 0,
    val email: String = "",
    val role: String = "",
    val username: String = "",
    val instagram_url: String = "",
    val age: Int = 0
)
