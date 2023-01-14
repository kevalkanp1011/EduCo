package dev.kevalkanpariya.featuretesteduco.domain.model

data class MessageBarState(
    val message: String? = null,
    val error: Exception? = null
)