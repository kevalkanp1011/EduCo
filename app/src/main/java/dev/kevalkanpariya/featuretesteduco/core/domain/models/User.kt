package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class User(
    val userId: String,
    val profilePictureUrl: String,
    val username: String,
    val name: String,
    val description: String,
    val followerCount: Int,
    val followingCount: Int,
    val postCount: Int
)