package dev.kevalkanpariya.featuretesteduco.feature_auth.data.remote.request

@kotlinx.serialization.Serializable
data class CreateAccountRequest(
    val email: String,
    val username: String,
    val password: String
)