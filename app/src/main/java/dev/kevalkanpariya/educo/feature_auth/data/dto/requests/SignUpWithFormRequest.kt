package dev.kevalkanpariya.educo.feature_auth.data.dto.requests

data class SignUpWithFormRequest(
    val username: String,
    val email: String,
    val name: String,
    val pwd: String
)
