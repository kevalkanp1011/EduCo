package dev.kevalkanpariya.featuretesteduco.feature_auth.data.remote.response

@kotlinx.serialization.Serializable
data class AuthResponse(
    val userId: String,
    val token: String
)
