package dev.kevalkanpariya.featuretesteduco.core.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Teacher(
    val name: String,
    val profileImageUrl: String
)