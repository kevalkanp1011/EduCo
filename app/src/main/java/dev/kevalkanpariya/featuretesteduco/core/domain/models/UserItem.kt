package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class UserItem(
    val userId: String,
    val name: String,
    val username: String,
    val profilePictureUrl: String,
    val bio: String? = "",
    val isFollowing: Boolean
)
