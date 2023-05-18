package dev.kevalkanpariya.featuretesteduco.core.domain.models


data class Comment(
    val id: String,
    val username: String,
    val profilePictureUrl: String,
    val formattedTime: String,
    val comment: String,
    val isLiked: Boolean,
    val likeCount: Int
)

data class NewComment(
    val commentId: String,
    val username: String,
    val profilePictureUrl: String,
    val formattedTime: String,
    val comment: String,
    val isLiked: Boolean,
    val likeCount: Int
)