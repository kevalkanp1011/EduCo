package dev.kevalkanpariya.featuretesteduco.core.domain.states

import dev.kevalkanpariya.featuretesteduco.core.util.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)