package dev.kevalkanpariya.featuretesteduco.feature_auth.data.remote.request

@kotlinx.serialization.Serializable
data class SignInRequest(
    val email: String,
    val password: String
)