package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class Feedback(
    val id: String,
    val username: String,
    val profilePictureUrl: String,
    val formattedTime: String,
    val feedback: String,
)
