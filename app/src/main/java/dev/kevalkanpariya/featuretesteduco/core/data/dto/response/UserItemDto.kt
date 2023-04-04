package dev.kevalkanpariya.featuretesteduco.core.data.dto.response

import dev.kevalkanpariya.featuretesteduco.core.domain.models.UserItem

@kotlinx.serialization.Serializable
data class UserItemDto(
    val userId: String,
    val username: String,
    val profilePictureUrl: String,
    val bio: String,
    val isFollowing: Boolean,
    val name: String
) {
    fun toUserItem(): UserItem {
        return UserItem(
            userId = userId,
            username = username,
            profilePictureUrl = profilePictureUrl,
            bio = bio,
            isFollowing = isFollowing,
            name = name
        )
    }
}