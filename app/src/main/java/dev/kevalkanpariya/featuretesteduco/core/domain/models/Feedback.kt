package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class Feedback(
    val id: String,
    val courseId: String,
    val username: String,
    val profilePictureUrl: String? = null,
    val formattedTime: String,
    val feedback: String,
)
