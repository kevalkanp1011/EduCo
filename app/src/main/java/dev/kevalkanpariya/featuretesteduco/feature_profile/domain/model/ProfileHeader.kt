package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model


@kotlinx.serialization.Serializable
data class ProfileHeader(
    val name: String,
    val profilePictureUrl: String
)
